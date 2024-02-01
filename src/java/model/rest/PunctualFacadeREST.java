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
import model.entitys.Punctual;
import model.entitys.Recurrent;
import model.enums.Importance;
import model.interfaces.PunctualInterface;

/**
 * Es el FacadeRESTful de la entidad Punctual.
 *
 * @author Ian.
 */
@Path("entitys.punctual")
public class PunctualFacadeREST extends ExpenseFacadeREST {

    @EJB
    private PunctualInterface pi;

    public PunctualFacadeREST() {

    }

    /**
     * Llama al metodo createPunctual del EJB mediante la interfaz.
     *
     * @param punctual el parametro necesario para el EJB.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createPunctual(Punctual punctual) throws CreateException {
        pi.createPunctual(punctual);
    }

    /**
     * Llama al metodo updatePunctual del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB
     * @param punctual el parametro necesario para el EJB.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @PUT
    @Path("{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePunctual(@PathParam("uuid") Long uuid, Punctual punctual) throws UpdateException {
        pi.updatePunctual(punctual);
    }

    /**
     * Llama al metodo deletePunctual del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @DELETE
    @Path("{uuid}")
    public void deletePunctual(@PathParam("uuid") Long uuid) throws DeleteException, SelectException {
        pi.deletePunctual(pi.findPunctual(uuid));
    }

    /**
     * Llama al metodo listAllPunctual del EJB mediante la interfaz.
     *
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> listAllPunctual() throws SelectException {
        return pi.listAllPunctuals();
    }

    /**
     * Llama al metodo findPunctual del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Punctual findPunctual(@PathParam("uuid") Long uuid) throws SelectException {
        return pi.findPunctual(uuid);
    }

    /**
     * Llama al metodo findPunctualsByAccount del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("findPunctualsByAccount/{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> findPunctualsByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return pi.findPunctualsByAccount(uuid);
    }

    /**
     * Llama al metodo filterPunctualsByName del EJB mediante la interfaz.
     *
     * @param name el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterPunctualsByName/{name}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualsByName(@PathParam("name") String name, @PathParam("account_id") Long account_id) throws SelectException {
        return pi.filterPunctualsByName(name, account_id);
    }

    /**
     * Llama al metodo filterPunctualsByConcept del EJB mediante la interfaz.
     *
     * @param concept el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterPunctualsByConcept/{concept}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualsByConcept(@PathParam("concept") String concept, @PathParam("account_id") Long account_id) throws SelectException {
        return pi.filterPunctualsByConcept(concept, account_id);
    }

    /**
     * Llama al metodo filterPunctualsWithHigherAmount del EJB mediante la
     * interfaz.
     *
     * @param amount el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterPunctualsWithHigherAmount/{amount}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualsWithHigherAmount(@PathParam("amount") Float amount, @PathParam("account_id") Long account_id) throws SelectException {
        return pi.filterPunctualsWithHigherAmount(amount, account_id);
    }

    /**
     * Llama al metodo filterPunctualsWithLowerAmount del EJB mediante la
     * interfaz.
     *
     * @param amount el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterPunctualsWithLowerAmount/{amount}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualsWithLowerAmount(@PathParam("amount") Float amount, @PathParam("account_id") Long account_id) throws SelectException {
        return pi.filterPunctualsWithLowerAmount(amount, account_id);
    }

    /**
     * Llama al metodo filterPunctualsByImportance del EJB mediante la interfaz.
     *
     * @param importance el parametro necesario para el EJB.
     * @param account_id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterPunctualByImportance/{importance}/{account_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Punctual> filterPunctualsByImportance(@PathParam("importance") Importance importance, @PathParam("account_id") Long account_id) throws SelectException {
        return pi.filterPunctualsByImportance(importance, account_id);
    }
}
