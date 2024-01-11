package model.rest;

import exceptions.SelectException;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entitys.Expense;
import model.interfaces.ExpenseInterface;

/**
 * Es el FacadeRESTful de la entidad Expense.
 *
 * @author Jason, Jessica.
 */
@Path("entitys.expense")
public class ExpenseFacadeREST {

    @EJB
    private ExpenseInterface ei;

    public ExpenseFacadeREST() {

    }

//    @POST
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void createRecurrent(Expense expense) throws CreateException {
//        ei.createExpense(expense);
//    }
//
//    @PUT
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void updateRecurrent(@PathParam("uuid") Long uuid, Expense expense) throws UpdateException {
//        ei.updateExpense(expense);
//    }
//
//    @DELETE
//    @Path("{uuid}")
//    public void deleteExpense(@PathParam("uuid") Long uuid) throws DeleteException, SelectException {
//        ei.deleteExpense(ei.findExpense(uuid));
//    }
    /**
     * Llama al metodo listAllExpenses del EJB mediante la interfaz.
     *
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Expense> listAllExpenses() throws SelectException {
//        return ei.listAllExpenses();
//    }
    /**
     * Llama al metodo findExpense del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
//    @GET
//    @Path("{uuid}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Expense findExpense(@PathParam("uuid") Long uuid) throws SelectException {
//        return ei.findExpense(uuid);
//    }
    /**
     * Llama al metodo findExpensesByAccount del EJB mediante la interfaz.
     *
     * @param uuid el parametro necesario para el EJB.
     * @return lo que devuelva el metodo del EJB.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("findExpensesByAccount/{uuid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Expense> findExpensesByAccount(@PathParam("uuid") Long uuid) throws SelectException {
        return ei.findExpensesByAccount(uuid);
    }
}
