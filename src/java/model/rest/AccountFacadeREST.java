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
import model.entitys.Account;
import model.interfaces.AccountInterface;

/**
 *
 * @author Jason.
 */
@Stateless
@Path("entitys.account")
public class AccountFacadeREST {

    @EJB
    private AccountInterface ai;

    public AccountFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createAccount(Account account) throws CreateException {
        ai.createAccount(account);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateAccount(Account account) throws UpdateException {
        ai.updateAccount(account);
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteAccount(Account account) throws DeleteException {
        ai.deleteAccount(account);
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account find(@PathParam("id") Long id) throws SelectException {
        return ai.findAccount(id);
    }

    @GET
    @Path("viewAllAccounts")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> viewAllAccounts() throws SelectException {
        return ai.viewAllAccounts();
    }

    @GET
    @Path("searchAllAccountsByUser/{mail}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> searchAllAccountsByUser(@PathParam("mail") String mail) throws SelectException {
        return ai.searchAllAccountsByUser(mail);
    }

    @GET
    @Path("filterAccountsByName/{name}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByName(@PathParam("name") String name) throws SelectException {
        return ai.filterAccountsByName(name);
    }

    @GET
    @Path("filterAccountsByDescription/{description}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByDescription(@PathParam("description") String description) throws SelectException {
        return ai.filterAccountsByDescription(description);
    }

    @GET
    @Path("filterAccountsWithHigherBalance/{balance}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsWithHigherBalance(@PathParam("balance") Float balance) throws SelectException {
        return ai.filterAccountsWithHigherBalance(balance);
    }

    @GET
    @Path("filterAccountsWithLowerBalance/{balance}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsWithLowerBalance(@PathParam("balance") Float balance) throws SelectException {
        return ai.filterAccountsWithLowerBalance(balance);
    }

    @GET
    @Path("filterAccountsByDivisa/{divisa}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> filterAccountsByDivisa(@PathParam("divisa") String divisa) throws SelectException {
        return ai.filterAccountsByDivisa(divisa);
    }
}
