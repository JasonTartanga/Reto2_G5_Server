package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.enums.Category;
import model.entitys.Expense;
import model.enums.Importance;
import model.enums.Period;

/**
 *
 * @author Jason.
 */
public interface ExpenseInterface {

    public void createExpense(Expense expense) throws CreateException;

    public void updateExpense(Expense expense) throws UpdateException;

    public void deleteExpense(Expense expense) throws DeleteException;

    public List<Expense> findAllExpenses() throws SelectException;

    public List<Expense> searchAllExpensesByAccount(String id) throws SelectException;

    public List<Expense> listAllRecurrents() throws SelectException;

    public List<Expense> listAllPunctual() throws SelectException;

    public List<Expense> searchAllRecurrentsByAccount(String id) throws SelectException;

    public List<Expense> searchAllPunctualByAccount(String id) throws SelectException;

    public List<Expense> filterExpensesByName(String name) throws SelectException;

    public List<Expense> filterExpensesByConcept(String concept) throws SelectException;

    public List<Expense> filterExpensesWithHigherAmount(String amount) throws SelectException;

    public List<Expense> filterExpensesWithLowerAmount(String amount) throws SelectException;

    public List<Expense> filterRecurrentByPeriodicity(Period periodicity) throws SelectException;

    public List<Expense> filterRecurrentByCategory(Category category) throws SelectException;

    public List<Expense> filterPunctualByImportance(Importance importance) throws SelectException;

}
