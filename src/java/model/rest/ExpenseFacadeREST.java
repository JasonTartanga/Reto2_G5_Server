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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> findExpensesByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return ei.findExpensesByAccount(uuid);
    }
}
