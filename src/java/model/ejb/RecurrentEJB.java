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
import model.entitys.Recurrent;
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
    public List<Expense> listAllRecurrents() throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("listAllRecurrents").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> searchAllRecurrentsByAccount(Long id) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("searchAllRecurrentsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterRecurrentByPeriodicity(String periodicity) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterRecurrentByPeriodicity").setParameter("periodicity", periodicity).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

    @Override
    public List<Expense> filterRecurrentByCategory(String category) throws SelectException {
        List<Expense> expenses = null;
        try {
            expenses
                    = em.createNamedQuery("filterRecurrentByCategory").setParameter("category", category).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return expenses;
    }

}
