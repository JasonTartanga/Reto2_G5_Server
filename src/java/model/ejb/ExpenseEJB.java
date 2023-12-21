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
    public List<Expense> findAllExpenses() throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("findAllExpenses").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> searchAllExpensesByAccount(Long id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public Expense findExpense(Long id) throws SelectException {
        Expense a = null;
        try {
            a = em.find(Expense.class, id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return a;
    }

    @Override
    public List<Expense> filterExpensesByName(String name) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterExpensesByName").setParameter("name", name).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterExpensesByConcept(String concept) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterExpensesByConcept").setParameter("concept", concept).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterExpensesWithHigherAmount(String amount) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterExpensesWithHigherAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterExpensesWithLowerAmount(String amount) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterExpensesWithLowerAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }
}
