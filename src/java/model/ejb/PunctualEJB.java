package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Expense;
import model.entitys.Punctual;
import model.interfaces.PunctualInterface;

/**
 *
 * @author Jason.
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
    public List<Expense> listAllPunctual() throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("listAllPunctual").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> searchAllPunctualByAccount(String id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("searchAllPunctualByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterPunctualByImportance(String importance) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterPunctualByImportance").setParameter("importance", importance).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

}
