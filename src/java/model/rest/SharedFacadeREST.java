package model.rest;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import model.entitys.Shared;
import model.entitys.SharedId;
import model.interfaces.SharedInterface;

/**
 *
 * @author Jason.
 */
@Stateless
@Path("entitys.shared")
public class SharedFacadeREST {

    @EJB
    private SharedInterface si;

    private SharedId getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;id=idValue;mail=mailValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.entitys.SharedId key = new model.entitys.SharedId();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Long(id.get(0)));
        }
        java.util.List<String> mail = map.get("mail");
        if (mail != null && !mail.isEmpty()) {
            key.setMail(mail.get(0));
        }
        return key;
    }

    public SharedFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Shared shared) throws CreateException {
        si.createShared(shared);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Shared shared) throws UpdateException {
        si.updateShared(shared);
    }

    @DELETE
    @Path("delete/{account_id}/{user_mail}")
    public void remove(@PathParam("account_id") Long account_id, @PathParam("account_id") String user_mail) throws SelectException, DeleteException {
        si.deleteShared(si.findShared(account_id, user_mail));
    }

    @GET
    @Path("findShared/{account_id}/{user_mail}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Shared findShared(@PathParam("account_id") Long account_id, @PathParam("account_id") String user_mail) throws SelectException {
        return si.findShared(account_id, user_mail);
    }

    @GET
    @Path("findAllShareds")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Shared> findAll() throws SelectException {
        return si.findAllShared();
    }
}
