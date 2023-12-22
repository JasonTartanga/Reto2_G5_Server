package model.ejb;

import exceptions.SelectException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Expense;
import model.entitys.Punctual;
import model.entitys.Recurrent;
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
        List<Expense> expenseNew = new ArrayList<>();
        try {
            expenses
                    = em.createNamedQuery("listAllExpenses").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenseNew;
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
            expenses = this.mappearList(expenses);
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
                    = em.createNamedQuery("filterExpensesByName").setParameter("name", "%" + name + "%").getResultList();
            expenses = this.mappearList(expenses);
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
                    = em.createNamedQuery("filterExpensesByConcept").setParameter("concept", "%" + concept + "%").getResultList();
            expenses = this.mappearList(expenses);
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
            expenses = this.mappearList(expenses);
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
            expenses = this.mappearList(expenses);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    public List<Expense> mappearList(List<Expense> expenses) throws SelectException {
        List<Expense> expensesNew = new ArrayList<>();

        for (Expense e : expenses) {
            expensesNew.add(this.findExpense(e.getUuid()));
        }
        return expensesNew;
    }
}
