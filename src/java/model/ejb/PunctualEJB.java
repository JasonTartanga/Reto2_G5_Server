package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Punctual;
import model.enums.Importance;
import model.interfaces.PunctualInterface;

/**
 *
 * @author Ian.
 */
@Stateless
public class PunctualEJB implements PunctualInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    @Override
    public void createPunctual(Punctual punctual) throws CreateException {
        try {
            em.persist(punctual);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updatePunctual(Punctual punctual) throws UpdateException {
        try {
            if (!em.contains(punctual)) {
                em.merge(punctual);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deletePunctual(Punctual punctual) throws DeleteException {
        try {
            em.remove(em.merge(punctual));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Punctual> listAllPunctuals() throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("listAllPunctuals").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public Punctual findPunctual(Long id) throws SelectException {
        Punctual p = null;
        try {
            p = em.find(Punctual.class, id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return p;
    }

    @Override
    public List<Punctual> findPunctualsByAccount(Long id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("findPunctualsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public List<Punctual> filterPunctualsByName(String name) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByName").setParameter("name", "%" + name + "%").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public List<Punctual> filterPunctualsByConcept(String concept) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByConcept").setParameter("concept", "%" + concept + "%").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public List<Punctual> filterPunctualsWithHigherAmount(String amount) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsWithHigherAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public List<Punctual> filterPunctualsWithLowerAmount(String amount) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsWithLowerAmount").setParameter("amount", amount).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    @Override
    public List<Punctual> filterPunctualsByImportance(Importance importance) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByImportance").setParameter("importance", importance).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

}
