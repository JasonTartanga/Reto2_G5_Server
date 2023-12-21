package model.interfaces;

import exceptions.SelectException;
import java.util.List;
import model.entitys.Expense;

/**
 *
 * @author Jason.
 */
public interface ExpenseInterface {

    public Expense findExpense(Long id) throws SelectException;

    public List<Expense> findAllExpenses() throws SelectException;

    public List<Expense> searchAllExpensesByAccount(Long id) throws SelectException;

    public List<Expense> filterExpensesByName(String name) throws SelectException;

    public List<Expense> filterExpensesByConcept(String concept) throws SelectException;

    public List<Expense> filterExpensesWithHigherAmount(String amount) throws SelectException;

    public List<Expense> filterExpensesWithLowerAmount(String amount) throws SelectException;

}
