package model.rest;

import cipher.Asimetric;
import cipher.EnviarMail;
import cipher.Hash;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entitys.User;
import model.interfaces.UserInterface;

/**
 * Es el FacadeRESTful de la entidad User.
 *
 * @author Ian.
 */
@Path("entitys.user")
public class UserFacadeREST {

    @EJB
    private UserInterface ui;

    public UserFacadeREST() {

    }

    /**
     * Llama al metodo createUser del EJB mediante la interfaz.
     *
     * @param user el parametro necesario para el EJB.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(User user) throws CreateException {
        String decipherPasswd = Asimetric.decipherPasswd(user.getPassword());
        user.setPassword(Hash.hashText(decipherPasswd));
        ui.createUser(user);
    }

    /**
     * Llama al metodo updateUser del EJB mediante la interfaz.
     *
     * @param mail el parametro necesario para el EJB.
     * @param user el parametro necesario para el EJB.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @PUT
    @Path("{mail}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(@PathParam("mail") String mail, User user) throws UpdateException {
        ui.updateUser(user);
    }

    /**
     * Llama al metodo deleteUser del EJB mediante la interfaz.
     *
     * @param mail el parametro necesario para el EJB.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @DELETE
    @Path("{mail}")
    public void deleteUser(@PathParam("mail") String mail) throws DeleteException, SelectException {
        ui.deleteUser(ui.findUser(mail));
    }

    /**
     * Llama al metodo findUser del EJB mediante la interfaz.
     *
     * @param mail el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("{mail}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User findUser(@PathParam("mail") String mail) throws SelectException {
        return ui.findUser(mail);
    }

    /**
     * Llama al metodo viewAllUser del EJB mediante la interfaz.
     *
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAllUsers() throws SelectException {
        return ui.viewAllUser();
    }

    /**
     * Llama al metodo loginUser del EJB mediante la interfaz.
     *
     * @param mail el parametro necesario para el EJB.
     * @param passwd el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("login/{mail}/{passwd}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User loginUser(@PathParam("mail") String mail, @PathParam("passwd") String passwd) throws SelectException {
        passwd = Asimetric.decipherPasswd(passwd);
        String passhax = Hash.hashText(passwd);
        return ui.loginUser(mail, passhax);
    }

    @GET
    @Path("changePassword/{mail}/{passwd}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void changePassword(@PathParam("mail") String mail, @PathParam("passwd") String passwd) throws SelectException {
        User user = findUser(mail);
        try {
            passwd = Asimetric.decipherPasswd(passwd);
            String passhax = Hash.hashText(passwd);
            user.setPassword(passhax);
            ui.updateUser(user);

            EnviarMail.enviarEmail(mail, "Cambio de contraseña", "Su contraseña se ha cambiado exitosamente");

        } catch (UpdateException ex) {
            Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("forgotPassword/{mail}")
    public void forgotPassword(@PathParam("mail") String mail) throws SelectException {
        User u = findUser(mail);
        if (u.getMail().equalsIgnoreCase(mail)) {
            try {
                String newPassword = EnviarMail.generarContrasena();
                u.setPassword(Hash.hashText(newPassword));
                ui.updateUser(u);

                String MESSAGE = "Tu nueva contraseña para iniciar sesion en CashTracker es: " + newPassword;
                EnviarMail.enviarEmail(mail, "Recuperacion de contraseña", MESSAGE);

            } catch (UpdateException ex) {
                Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
