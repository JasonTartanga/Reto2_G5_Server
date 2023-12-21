package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.User;
import model.interfaces.UserInterface;

/**
 *
 * @author Ian.
 */
@Stateless
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
    public User findUser(String mail) throws SelectException {
        User u = null;
        try {
            u = (User) em.find(User.class, mail);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return u;
    }

    @Override
    public List<User> viewAllUser() throws SelectException {
        List<User> users = null;
        try {
            users
                    = em.createNamedQuery("viewAllUsers").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return users;
    }

    @Override
    public User loginUser(String mail, String passwd) throws SelectException {
        User u = null;
        try {
            u = (User) em.createNamedQuery("loginUser").setParameter("mail", mail).setParameter("password", passwd).getSingleResult();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }

        return u;
    }
}
