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

    /**
     * Busca la cantidad de Expenses que hay.
     *
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @GET
    @Path("countExpenses")
    public Long countExpenses() throws SelectException {
        return ei.countExpenses();
    }
}
