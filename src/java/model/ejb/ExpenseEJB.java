package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Expense;
import model.entitys.Recurrent;
import model.interfaces.ExpenseInterface;

/**
 * Es el EJB de la entidad Expense.
 *
 * @author Jason, Ian.
 */
@Stateless
public class ExpenseEJB implements ExpenseInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(ExpenseEJB.class.getName());

    /**
     * Busca la cantidad de Expenses que hay.
     *
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Long countExpenses() throws SelectException {
        List<Expense> expenses;
        try {
            expenses
                    = em.createNamedQuery("listAllExpenses").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return Long.parseLong(expenses.size() + "");
    }
}
