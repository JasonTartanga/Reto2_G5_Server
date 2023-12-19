package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Category;
import model.entitys.Expense;
import model.entitys.Importance;
import model.entitys.Period;
import model.interfaces.ExpenseInterface;

/**
 *
 * @author Jason.
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
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("findAllExpenses").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> searchAllExpensesByAccount(String id) throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> listAllRecurrents() throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("listAllRecurrents").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> listAllPunctual() throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("listAllPunctual").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> searchAllRecurrentsByAccount(String id) throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> filterExpensesByName(String name) throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> filterExpensesByConcept(String concept) throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    public List<Expense> filterExpensesWithHigherAmount(String amount) throws SelectException {
        List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;
    }

    @Override
    List<Expense> expense = null;


        try {
            expense
                = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
    }
    catch (Exception e


        ) {
            throw new SelectException(e.getMessage());
    }
    return expense ;
}

@Override
   List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;}

    @Override
        public List<Expense> filterRecurrentByCategory(Category category) throws SelectException {
     List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense;}

    @Override
        public List<Expense> filterPunctualByImportance(Importance importance) throws SelectException {
   List<Expense> expense = null;
        try {
            expense
                    = em.createNamedQuery("searchAllExpensesByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expense; }

}
