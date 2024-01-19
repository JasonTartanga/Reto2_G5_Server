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
import model.entitys.Account;
import model.enums.Plan;
import model.interfaces.AccountInterface;

/**
 * Es el FacadeRESTful de la entidad Account.
 *
 * @author Jessica.
 */
@Path("entitys.account")
public class AccountFacadeREST {

    @EJB
    private AccountInterface ai;

    public AccountFacadeREST() {

    }

    /**
     * Llama al metodo createAccount del EJB mediante la interfaz.
     *
     * @param account el Account que queremos crear.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createAccount(Account account) throws CreateException {
        ai.createAccount(account);
    }

    /**
     * Llama al metodo updateAccount del EJB mediante la interfaz.
     *
     * @param account el Account que queremos modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateAccount(Account account) throws UpdateException {
        ai.updateAccount(account);
    }

    /**
     * Llama al metodo deleteAccount del EJB mediante la interfaz.
     *
     * @param id el parametro necesario para el EJB.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @DELETE
    @Path("{id}")
    public void deleteAccount(@PathParam("id") Long id) throws DeleteException, SelectException {
        ai.deleteAccount(ai.findAccount(id));
    }

    /**
     * Llama al metodo findAccount del EJB mediante la interfaz.
     *
     * @param id el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account findAccount(@PathParam("id") Long id) throws SelectException {
        return ai.findAccount(id);
    }

    /**
     * Llama al metodo viewAllAccounts del EJB mediante la interfaz.
     *
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> viewAllAccounts() throws SelectException {
        return ai.viewAllAccounts();
    }

    /**
     * Llama al metodo findAllAccountsByUser del EJB mediante la interfaz.
     *
     * @param mail el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("findAllAccountsByUser/{mail}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> findAllAccountsByUser(@PathParam("mail") String mail) throws SelectException {
        return ai.findAllAccountsByUser(mail);
    }

    /**
     * Llama al metodo filterAccountsByName del EJB mediante la interfaz.
     *
     * @param name el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByName(@PathParam("name") String name) throws SelectException {
        return ai.filterAccountsByName(name);
    }

    /**
     * Llama al metodo filterAccountsByDescription del EJB mediante la interfaz.
     *
     * @param description el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsByDescription/{description}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByDescription(@PathParam("description") String description) throws SelectException {
        return ai.filterAccountsByDescription(description);
    }

    /**
     * Llama al metodo filterAccountsWithHigherBalance del EJB mediante la
     * interfaz.
     *
     * @param balance el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsWithHigherBalance/{balance}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsWithHigherBalance(@PathParam("balance") Float balance) throws SelectException {
        return ai.filterAccountsWithHigherBalance(balance);
    }

    /**
     * Llama al metodo filterAccountsWithLowerBalance del EJB mediante la
     * interfaz.
     *
     * @param balance el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsWithLowerBalance/{balance}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsWithLowerBalance(@PathParam("balance") Float balance) throws SelectException {
        return ai.filterAccountsWithLowerBalance(balance);
    }

    /**
     * Llama al metodo filterAccountsByDivisa del EJB mediante la interfaz.
     *
     * @param divisa el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsByDivisa/{divisa}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByDivisa(@PathParam("divisa") String divisa) throws SelectException {
        return ai.filterAccountsByDivisa(divisa);
    }
    
    /**
     * Llama al metodo filterAccountsByPlan del EJB mediante la interfaz.
     * @param plan el parametro necesario para el EJB
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("filterAccountsByPlan/{plan}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByPlan(@PathParam("plan") Plan plan) throws SelectException {
        return ai.filterAccountsByPlan(plan);
    }
}
