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
 * Es el EJB de la entidad User.
 *
 * @author Ian.
 */
@Stateless
public class UserEJB implements UserInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    /**
     * Crea un usuario en la base de datos.
     *
     * @param user el usuario que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @Override
    public void createUser(User user) throws CreateException {
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Modifica un usuario de la base de datos.
     *
     * @param user el usuario que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
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

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param user el usuario que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    @Override
    public void deleteUser(User user) throws DeleteException {
        try {
            em.remove(em.merge(user));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Busca un usuario por su mail.
     *
     * @param mail el identificador unico del usuario.
     * @return todos los datos del usuario.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
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

    /**
     * Busca todos los usuario de la base de datos.
     *
     * @return todos los usuarios.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
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

    /**
     * Mira en la base de datos si un usuario contiene el mail y la contraseña,
     * si coinciden devuelve el todos datos del usuario, si no devuelve null
     *
     * @param mail el identificador unico del usuario.
     * @param passwd la contraseña del usuario.
     * @return todos los datos del usuario o null.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
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
