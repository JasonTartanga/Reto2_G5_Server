package model.ejb;

import exceptions.SelectException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Expense;
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
        Long countExpenses = null;

        try {
            countExpenses = (Long) em.createNamedQuery("countExpenses").getSingleResult();

        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return countExpenses;
    }

    /**
     * Busca todos los Expenses que tenga un Account.
     *
     * @param id el identificador unico del Account
     * @return todos los Expenses de un Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Expense> listAllExpensesByAccount(Long id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("listAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }
}
