package model.rest;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
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
 *
 * @author Ian.
 */
@Path("entitys.user")
public class UserFacadeREST {

    @EJB
    private UserInterface ui;

    public UserFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(User user) throws CreateException {
        ui.createUser(user);
    }

    @PUT
    @Path("update/{mail}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(@PathParam("mail") String mail, User user) throws UpdateException {
        ui.updateUser(user);
    }

    @DELETE
    @Path("delete/{mail}")
    public void deleteUser(@PathParam("mail") String mail) throws DeleteException, SelectException {
        ui.deleteUser(ui.findUser(mail));
    }

    @GET
    @Path("find/{mail}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("mail") String mail) throws SelectException {
        return ui.findUser(mail);
    }

    @GET
    @Path("findAllUsers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAllUsers() throws SelectException {
        return ui.viewAllUser();
    }

    @GET
    @Path("loging/{mail}/{passwd}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User loginUser(@PathParam("mail") String mail, @PathParam("passwd") String passwd) throws SelectException {
        return ui.loginUser(mail, passwd);
    }
}
