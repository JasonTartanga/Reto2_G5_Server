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
import javax.ws.rs.core.MediaType;
import model.entitys.Expense;
import model.entitys.Recurrent;
import model.interfaces.RecurrentInterface;

/**
 *
 * @author Jason.
 */
@Stateless
@Path("entitys.recurrent")
public class RecurrentFacadeREST {

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
    @Path("delete/{id}")
    public void deleteRecurrent(Recurrent recurrent) throws DeleteException {
        ri.deleteRecurrent(recurrent);
    }

    @GET
    @Path("listAllRecurrents")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> listAllRecurrents() throws SelectException {
        return ri.listAllRecurrents();
    }

    @GET
    @Path("searchAllRecurrentsByAccount/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> searchAllRecurrentsByAccount(@PathParam("id") String id) throws SelectException {
        return ri.searchAllRecurrentsByAccount(id);
    }

    @GET
    @Path("filterRecurrentByPeriodicity/{periodicity}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterRecurrentByPeriodicity(@PathParam("periodicity") String periodicity) throws SelectException {
        return ri.filterRecurrentByPeriodicity(periodicity);
    }

    @GET
    @Path("filterRecurrentByCategory/{category}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterRecurrentByCategory(@PathParam("category") String category) throws SelectException {
        return ri.filterRecurrentByCategory(category);
    }

}
