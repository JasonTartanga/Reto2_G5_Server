package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Expense;

/**
 * Es la interfaz de la entidad Expense.
 *
 * @author Jason, Ian.
 */
public interface ExpenseInterface {

    public void createExpense(Expense expense) throws CreateException;

    public void updateExpense(Expense expense) throws UpdateException;

    public void deleteExpense(Expense expense) throws DeleteException;

    public Expense findExpense(Long id) throws SelectException;

    /**
     * Busca todos los Expense que hay en la base de datos.
     *
     * @return todos los Expense y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Expense> listAllExpenses() throws SelectException;

    /**
     * Busca un Expense por id
     *
     * @param id el identificador unico del Expense.
     * @return todos los datos del Expense.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    /**
     * Busca todos los Expenses que tenga un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Expenses de un Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Expense> findExpensesByAccount(Long id) throws SelectException;
}
