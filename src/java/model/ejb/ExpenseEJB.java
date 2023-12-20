package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.enums.Category;
import model.entitys.Expense;
import model.enums.Importance;
import model.enums.Period;
import model.interfaces.ExpenseInterface;

/**
 *
 * @author Jason, Ian.
 */
public class ExpenseEJB implements ExpenseInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

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
        try {
            em.remove(em.merge(expense));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

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
    public List<Expense> searchAllExpensesByAccount(String id) throws SelectException {
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
    public List<Expense> listAllRecurrents() throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("listAllRecurrents").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> listAllPunctual() throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("listAllPunctual").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> searchAllRecurrentsByAccount(String id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("searchAllRecurrentsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> searchAllPunctualByAccount(String id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("searchAllPunctualByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
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

    @Override
    public List<Expense> filterRecurrentByPeriodicity(Period periodicity) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterRecurrentByPeriodicity").setParameter("periodicity", periodicity).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterRecurrentByCategory(Category category) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterRecurrentByCategory").setParameter("category", category).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterPunctualByImportance(Importance importance) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterPunctualByImportance").setParameter("importance", importance).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }
}
