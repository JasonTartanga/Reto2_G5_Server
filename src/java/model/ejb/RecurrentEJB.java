package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Recurrent;
import model.enums.Category;
import model.enums.Period;
import model.interfaces.RecurrentInterface;

/**
 *
 * @author Jason.
 */
@Stateless
public class RecurrentEJB implements RecurrentInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    @Override
    public void createRecurrent(Recurrent recurrent) throws CreateException {
        try {
            em.persist(recurrent);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateRecurrent(Recurrent recurrent) throws UpdateException {
        try {
            if (!em.contains(recurrent)) {
                em.merge(recurrent);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteRecurrent(Recurrent recurrent) throws DeleteException {
        try {
            em.remove(em.merge(recurrent));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Recurrent> listAllRecurrents() throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("listAllRecurrents").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public Recurrent findRecurrent(Long id) throws SelectException {
        Recurrent r = null;
        try {
            r = em.find(Recurrent.class, id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return r;
    }

    @Override
    public List<Recurrent> findRecurrentsByAccount(Long id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("findRecurrentsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsByName(String name) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByName").setParameter("name", "%" + name + "%").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsByConcept(String concept) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByConcept").setParameter("concept", "%" + concept + "%").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsWithHigherAmount(String amount) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsWithHigherAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsWithLowerAmount(String amount) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsWithLowerAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsByPeriodicity(Period periodicity) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentByPeriodicity").setParameter("periodicity", periodicity).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    @Override
    public List<Recurrent> filterRecurrentsByCategory(Category category) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentByCategory").setParameter("category", category).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

}
