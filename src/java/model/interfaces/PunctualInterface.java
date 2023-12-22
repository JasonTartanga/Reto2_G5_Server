package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Punctual;

/**
 *
 * @author Ian.
 */
public interface PunctualInterface {

    public void createPunctual(Punctual punctual) throws CreateException;

    public void updatePunctual(Punctual punctual) throws UpdateException;

    public void deletePunctual(Punctual punctual) throws DeleteException;

    public List<Punctual> listAllPunctuals() throws SelectException;

    public Punctual findPunctual(Long id) throws SelectException;

    public List<Punctual> findPunctualsByAccount(Long id) throws SelectException;

    public List<Punctual> filterPunctualByImportance(String importance) throws SelectException;

}
