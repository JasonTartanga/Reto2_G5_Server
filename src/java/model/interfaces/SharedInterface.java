package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Shared;

/**
 *
 * @author Jason.
 */
public interface SharedInterface {

    public void createShared(Shared shared) throws CreateException;

    public void updateShared(Shared shared) throws UpdateException;

    public void deleteShared(Shared shared) throws DeleteException;

    public Shared findShared(String id) throws SelectException;

    public List<Shared> findAllShared() throws SelectException;
}
