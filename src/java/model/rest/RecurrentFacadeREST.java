package model.rest;

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
import model.entitys.Recurrent;
import model.enums.Category;
import model.enums.Period;
import model.interfaces.RecurrentInterface;

/**
 * Es el FacadeRESTful de la entidad Recurrent.
 *
 * @author Jason.
 */
@Path("entitys.recurrent")
public class RecurrentFacadeREST extends ExpenseFacadeREST {

    @EJB
    private RecurrentInterface ri;

    public RecurrentFacadeREST() {

    }

    /**
     * Llama al metodo createRecurrent del EJB mediante la interfaz.
     *
     * @param recurrent el parametro necesario para el EJB.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createRecurrent(Recurrent recurrent) throws CreateException {
        ri.createRecurrent(recurrent);
    }

    /**
     * Llama al metodo updateRecurrent del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @param recurrent el parametro necesario para el EJB.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @PUT
    @Path("{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateRecurrent(@PathParam("uuid") Long uuid, Recurrent recurrent) throws UpdateException {
        ri.updateRecurrent(recurrent);
    }

    /**
     * Llama al metodo deleteRecurrent del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @DELETE
    @Path("{uuid}")
    public void deleteRecurrent(@PathParam("uuid") Long uuid) throws DeleteException, SelectException {
        ri.deleteRecurrent(ri.findRecurrent(uuid));
    }

    /**
     * Llama al metodo listAllRecurrents del EJB mediante la interfaz.
     *
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> listAllRecurrents() throws SelectException {
        return ri.listAllRecurrents();
    }

    /**
     * Llama al metodo findRecurrent del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Recurrent findRecurrent(@PathParam("uuid") Long uuid) throws SelectException {
        return ri.findRecurrent(uuid);
    }

    /**
     * Llama al metodo findRecurrentsByAccount del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("findRecurrentsByAccount/{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> findRecurrentsByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return ri.findRecurrentsByAccount(uuid);
    }

    /**
     * Llama al metodo filterRecurrentsByName del EJB mediante la interfaz.
     *
     * @param name el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsByName/{name}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentsByName(@PathParam("name") String name, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsByName(name, account_id);
    }

    /**
     * Llama al metodo filterRecurrentsByConcept del EJB mediante la interfaz.
     *
     * @param concept el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsByConcept/{concept}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentsByConcept(@PathParam("concept") String concept, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsByConcept(concept, account_id);
    }

    /**
     * Llama al metodo filterRecurrentsWithHigherAmount del EJB mediante la
     * interfaz.
     *
     * @param amount el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsWithHigherAmount/{amount}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentsWithHigherAmount(@PathParam("amount") Float amount, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsWithHigherAmount(amount, account_id);
    }

    /**
     * Llama al metodo filterRecurrentsWithLowerAmount del EJB mediante la
     * interfaz.
     *
     * @param amount el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsWithLowerAmount/{amount}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentsWithLowerAmount(@PathParam("amount") Float amount, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsWithLowerAmount(amount, account_id);
    }

    /**
     * Llama al metodo filterRecurrentByPeriodicity del EJB mediante la
     * interfaz.
     *
     * @param periodicity el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsByPeriodicity/{periodicity}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentByPeriodicity(@PathParam("periodicity") Period periodicity, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsByPeriodicity(periodicity, account_id);
    }

    /**
     * Llama al metodo filterRecurrentByCategory del EJB mediante la interfaz.
     *
     * @param category el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterRecurrentsByCategory/{category}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recurrent> filterRecurrentByCategory(@PathParam("category") Category category, @PathParam("account_id") Long account_id) throws SelectException {
        return ri.filterRecurrentsByCategory(category, account_id);
    }

}
