package model.interfaces;

import exceptions.SelectException;

/**
 * Es la interfaz de la entidad Expense.
 *
 * @author Jason, Ian.
 */
public interface ExpenseInterface {

    /**
     * Busca la cantidad de Expenses que hay.
     *
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
    public Long countExpenses() throws SelectException;
}
