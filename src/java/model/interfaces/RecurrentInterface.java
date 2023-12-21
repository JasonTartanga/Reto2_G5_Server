package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Expense;
import model.entitys.Recurrent;

/**
 *
 * @author Jason.
 */
public interface RecurrentInterface {

    public void createRecurrent(Recurrent recurrent) throws CreateException;

    public void updateRecurrent(Recurrent recurrent) throws UpdateException;

    public void deleteRecurrent(Recurrent recurrent) throws DeleteException;

    public List<Expense> listAllRecurrents() throws SelectException;

    public List<Expense> searchAllRecurrentsByAccount(Long id) throws SelectException;

    public List<Expense> filterRecurrentByPeriodicity(String periodicity) throws SelectException;

    public List<Expense> filterRecurrentByCategory(String category) throws SelectException;

}
