package model.rest;

import exceptions.SelectException;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entitys.Expense;
import model.interfaces.ExpenseInterface;

/**
 *
 * @author Jason, Jessica.
 */
@Path("expense")
public class ExpenseFacadeREST {

    @EJB
    private ExpenseInterface ei;

    public ExpenseFacadeREST() {

    }

    @GET
    @Path("listAllExpenses")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> listAllExpenses() throws SelectException {
        return ei.listAllExpenses();
    }

    @GET
    @Path("findExpense/{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Expense findExpense(@PathParam("uuid") Long uuid) throws SelectException {
        return ei.findExpense(uuid);
    }

    @GET
    @Path("findExpensesByAccount/{uuid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> findExpensesByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return ei.findExpensesByAccount(uuid);
    }

    @GET
    @Path("filterExpensesByName/{name}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterExpensesByName(@PathParam("name") String name) throws SelectException {
        return ei.filterExpensesByName(name);
    }

    @GET
    @Path("filterExpensesByConcept/{concept}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterExpensesByConcept(@PathParam("concept") String concept) throws SelectException {
        return ei.filterExpensesByConcept(concept);
    }

    @GET
    @Path("filterExpensesWithHigherAmount/{amount}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterExpensesWithHigherAmount(@PathParam("amount") String amount) throws SelectException {
        return ei.filterExpensesWithHigherAmount(amount);
    }

    @GET
    @Path("filterExpensesWithLowerAmount/{amount}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> filterExpensesWithLowerAmount(@PathParam("amount") String amount) throws SelectException {
        return ei.filterExpensesWithLowerAmount(amount);
    }

}
