package model.ejb;

import exceptions.SelectException;
import java.util.List;
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

    /**
     * Busca todos los Expense que hay en la base de datos.
     *
     * @return todos los Expense y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Expense> listAllExpenses() throws SelectException {
        List<Expense> expenses = null;

        try {
            expenses
                    = em.createNamedQuery("listAllExpenses").getResultList();

        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    /**
     * Busca un Expense por id
     *
     * @param id el identificador unico del Expense.
     * @return todos los datos del Expense.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Expense findExpense(Long id) throws SelectException {
        Expense e = null;
        try {
            e = em.find(Expense.class, id);
        } catch (Exception ex) {
            throw new SelectException(ex.getMessage());
        }
        return e;
    }

    /**
     * Busca todos los Expenses que tenga un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Expenses de un Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Expense> findExpensesByAccount(Long id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("findExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }
}
