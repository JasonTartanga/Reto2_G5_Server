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
 *
 * @author Jason.
 */
@Stateless
public class SharedEJB implements SharedInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    @Override
    public void createShared(Shared shared) throws CreateException {
        try {
            em.persist(shared);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

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

    @Override
    public void deleteShared(Shared shared) throws DeleteException {
        try {
            em.remove(em.merge(shared));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public Shared findShared(Long account_id, String mail) throws SelectException {
        Shared s = null;
        try {
            s
                    = (Shared) em.createNamedQuery("findShared").setParameter("id", account_id).setParameter("mail", mail).getSingleResult();

        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return s;
    }

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

}
