package model.rest;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author Jason.
 */
@Stateless
@Path("entitys.user")
public class UserFacadeREST {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

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
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(@PathParam("id") String id, User user) throws UpdateException {
        ui.updateUser(user);
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteUser(@PathParam("id") String id) throws DeleteException, SelectException {
        ui.deleteUser(ui.findUser(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") String id) {
        //  return super.find(id);
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAllUsers() throws SelectException {
        return ui.viewAllUser();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User loginUser(User user) throws SelectException {
        return ui.loginUser(user);
    }
}
