package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Expense;
import model.entitys.Punctual;

/**
 *
 * @author Jason.
 */
public interface PunctualInterface {

    public void createPunctual(Punctual punctual) throws CreateException;

    public void updatePunctual(Punctual punctual) throws UpdateException;

    public void deletePunctual(Punctual punctual) throws DeleteException;

    public List<Expense> listAllPunctual() throws SelectException;

    public List<Expense> searchAllPunctualByAccount(String id) throws SelectException;

    public List<Expense> filterPunctualByImportance(String importance) throws SelectException;

}
