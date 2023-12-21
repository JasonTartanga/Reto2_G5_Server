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
import model.entitys.Punctual;
import model.interfaces.PunctualInterface;

/**
 *
 * @author Jason.
 */
@Stateless
@Path("entitys.punctual")
public class PunctualFacadeREST {

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
    @Path("delete/{id}")
    public void deletePunctual(Punctual punctual) throws DeleteException {
        pi.deletePunctual(punctual);
    }

    @GET
    @Path("listAllPunctual")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> listAllPunctual() throws SelectException {
        return pi.listAllPunctual();
    }

    @GET
    @Path("searchAllPunctualByAccount/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> searchAllPunctualByAccount(@PathParam("id") Long id) throws SelectException {
        return pi.searchAllPunctualByAccount(id);
    }

    @GET
    @Path("filterPunctualByImportance/{importance}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterPunctualByImportance(@PathParam("importance") String importance) throws SelectException {
        return pi.filterPunctualByImportance(importance);
    }
}
