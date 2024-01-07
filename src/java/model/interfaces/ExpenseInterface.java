package model.interfaces;

import exceptions.SelectException;
import java.util.List;
import model.entitys.Expense;

/**
 * Es la interfaz de la entidad Expense.
 *
 * @author Jason, Ian.
 */
public interface ExpenseInterface {

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
    public Expense findExpense(Long id) throws SelectException;

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
