package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.User;
import model.interfaces.UserInterface;

/**
 *
 * @author Ian.
 */
public class UserEJB implements UserInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    @Override
    public void createUser(User user) throws CreateException {
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws UpdateException {
        try {
            if (!em.contains(user)) {
                em.merge(user);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) throws DeleteException {
        try {
            em.remove(em.merge(user));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<User> viewAllUser() throws SelectException {
        List<User> users = null;
        try {
            users
                    = em.createNamedQuery("viewAllAccounts").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return users;
    }

    @Override
    public User loginUser(User user) throws SelectException {
        List<User> users = null;
        try {
            users
                    = em.createNamedQuery("searchAllAccountsByUser").setParameter("mail", user.getMail()).setParameter("password", user.getPassword()).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }

        return users.get(0);
    }

}
