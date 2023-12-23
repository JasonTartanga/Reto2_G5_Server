package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Punctual;
import model.entitys.Recurrent;
import model.enums.Category;
import model.enums.Period;

/**
 *
 * @author Jason.
 */
public interface RecurrentInterface {

    public void createRecurrent(Recurrent recurrent) throws CreateException;

    public void updateRecurrent(Recurrent recurrent) throws UpdateException;

    public void deleteRecurrent(Recurrent recurrent) throws DeleteException;

    public List<Recurrent> listAllRecurrents() throws SelectException;

    public Recurrent findRecurrent(Long id) throws SelectException;

    public List<Recurrent> findRecurrentsByAccount(Long id) throws SelectException;

    public List<Recurrent> filterRecurrentsByName(String name) throws SelectException;

    public List<Recurrent> filterRecurrentsByConcept(String concept) throws SelectException;

    public List<Recurrent> filterRecurrentsWithHigherAmount(String amount) throws SelectException;

    public List<Recurrent> filterRecurrentsWithLowerAmount(String amount) throws SelectException;

    public List<Recurrent> filterRecurrentsByPeriodicity(Period periodicity) throws SelectException;

    public List<Recurrent> filterRecurrentsByCategory(Category category) throws SelectException;

}
