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
import model.entitys.Recurrent;
import model.interfaces.RecurrentInterface;

/**
 *
 * @author Jason.
 */
@Path("entitys.recurrent")
public class RecurrentFacadeREST extends ExpenseFacadeREST {

    @EJB
    private RecurrentInterface ri;

    public RecurrentFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createRecurrent(Recurrent recurrent) throws CreateException {
        ri.createRecurrent(recurrent);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateRecurrent(Recurrent recurrent) throws UpdateException {
        ri.updateRecurrent(recurrent);
    }

    @DELETE
    @Path("delete/{uuid}")
    public void deleteRecurrent(@PathParam("uuid") Long uuid) throws DeleteException, SelectException {
        ri.deleteRecurrent(ri.findRecurrent(uuid));
    }

    @GET
    @Path("listAllRecurrents")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> listAllRecurrents() throws SelectException {
        return ri.listAllRecurrents();
    }

    @GET
    @Path("findRecurrent/{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Recurrent findRecurrent(@PathParam("uuid") Long uuid) throws SelectException {
        return ri.findRecurrent(uuid);
    }

    @GET
    @Path("findRecurrentsByAccount/{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> findRecurrentsByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return ri.findRecurrentsByAccount(uuid);
    }

    @GET
    @Path("filterRecurrentByPeriodicity/{periodicity}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentByPeriodicity(@PathParam("periodicity") String periodicity) throws SelectException {
        return ri.filterRecurrentByPeriodicity(periodicity);
    }

    @GET
    @Path("filterRecurrentByCategory/{category}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentByCategory(@PathParam("category") String category) throws SelectException {
        return ri.filterRecurrentByCategory(category);
    }

}
