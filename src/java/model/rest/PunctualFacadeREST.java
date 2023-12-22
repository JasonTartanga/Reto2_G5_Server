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
import javax.ws.rs.core.MediaType;
import model.entitys.Punctual;
import model.interfaces.PunctualInterface;

/**
 *
 * @author Ian.
 */
@Path("entitys.punctual")
public class PunctualFacadeREST extends ExpenseFacadeREST {

    @EJB
    private PunctualInterface pi;

    public PunctualFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createPunctual(Punctual punctual) throws CreateException {
        pi.createPunctual(punctual);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePunctual(Punctual punctual) throws UpdateException {
        pi.updatePunctual(punctual);
    }

    @DELETE
    @Path("delete/{uuid}")
    public void deletePunctual(@PathParam("uuid") Long uuid) throws DeleteException, SelectException {
        pi.deletePunctual(pi.findPunctual(uuid));
    }

    @GET
    @Path("listAllPunctual")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> listAllPunctual() throws SelectException {
        return pi.listAllPunctuals();
    }

    @GET
    @Path("findPunctual/{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Punctual findPunctual(@PathParam("uuid") Long uuid) throws SelectException {
        return pi.findPunctual(uuid);
    }

    @GET
    @Path("findPunctualsByAccount/{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> findPunctualsByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return pi.findPunctualsByAccount(uuid);
    }

    @GET
    @Path("filterPunctualByImportance/{importance}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualByImportance(@PathParam("importance") String importance) throws SelectException {
        return pi.filterPunctualByImportance(importance);
    }
}
