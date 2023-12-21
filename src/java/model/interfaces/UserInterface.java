package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.User;

/**
 *
 * @author Ian.
 */
public interface UserInterface {

    public void createUser(User user) throws CreateException;

    public void updateUser(User user) throws UpdateException;

    public void deleteUser(User user) throws DeleteException;

    public User findUser(String mail) throws SelectException;

    public List<User> viewAllUser() throws SelectException;

    public User loginUser(User user) throws SelectException;

}
