package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Shared;
import model.interfaces.SharedInterface;

/**
 * El EJB de la entidad Shared.
 *
 * @author Jason, Jessica.
 */
@Stateless
public class SharedEJB implements SharedInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    /**
     * Crea un Shared en la base de datos.
     *
     * @param shared el Shared que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @Override
    public void createShared(Shared shared) throws CreateException {
        try {
            if (!em.contains(shared.getAccount())) {
                shared.setAccount(em.merge(shared.getAccount()));
            }

            if (!em.contains(shared.getUser())) {
                shared.setUser(em.merge(shared.getUser()));
            }
            em.persist(shared);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Modifica un Shared de la base de datos.
     *
     * @param shared los datos del Shared que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @Override
    public void updateShared(Shared shared) throws UpdateException {
        try {
            if (!em.contains(shared)) {
                em.merge(shared);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    /**
     * Elimina un Shared de la base de datos.
     *
     * @param shared el shared que se va a eliminar
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    @Override
    public void deleteShared(Shared shared) throws DeleteException {
        try {
            em.remove(em.merge(shared));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Busca un Shared en la base de datos.
     *
     * @param account_id el identificado unico del Account.
     * @param mail el identificador unico del User.
     * @return todos los datos del Shared.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Shared findShared(Long account_id, String mail) throws SelectException {
        Shared s = null;
        try {
            s = (Shared) em.createNamedQuery("findShared").setParameter("id", account_id).setParameter("mail", mail).getSingleResult();

        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return s;
    }

    /**
     * Busca todos los Shared de la base de datos.
     *
     * @return todos los Shared y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Shared> findAllShared() throws SelectException {
        List<Shared> shareds = null;
        try {
            shareds
                    = em.createNamedQuery("findAllShared").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return shareds;
    }

    /**
     * Busca todos los Shared de un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Shared de un Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Shared> findAllSharedByAccount(Long id) throws SelectException {
        List<Shared> shareds = null;
        try {
            shareds
                    = em.createNamedQuery("findAllSharedByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return shareds;
    }

}
