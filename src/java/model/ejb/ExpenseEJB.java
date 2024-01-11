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

    @Override
    public void createExpense(Expense expense) throws CreateException {
        try {
            em.persist(expense);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateExpense(Expense expense) throws UpdateException {
        try {
            if (!em.contains(expense)) {
                em.merge(expense);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteExpense(Expense expense) throws DeleteException {
        log.warning("Delete Expense --> " + expense.getUuid());
        try {
            em.remove(em.merge(expense));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

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
