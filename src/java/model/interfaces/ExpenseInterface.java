package model.interfaces;

import exceptions.SelectException;
import java.util.List;
import model.entitys.Expense;

/**
 *
 * @author Jason, Ian.
 */
public interface ExpenseInterface {

    public List<Expense> listAllExpenses() throws SelectException;

    public Expense findExpense(Long id) throws SelectException;

    public List<Expense> findExpensesByAccount(Long id) throws SelectException;

    public List<Expense> filterExpensesByName(String name) throws SelectException;

    public List<Expense> filterExpensesByConcept(String concept) throws SelectException;

    public List<Expense> filterExpensesWithHigherAmount(String amount) throws SelectException;

    public List<Expense> filterExpensesWithLowerAmount(String amount) throws SelectException;

}
