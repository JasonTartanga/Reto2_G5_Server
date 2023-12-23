package model.ejb;

import exceptions.SelectException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Expense;
import model.interfaces.ExpenseInterface;

/**
 *
 * @author Jason, Ian.
 */
@Stateless
public class ExpenseEJB implements ExpenseInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

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
