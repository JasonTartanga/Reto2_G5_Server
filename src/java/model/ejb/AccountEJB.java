package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Account;
import model.interfaces.AccountInterface;

/**
 *
 * @author Jessica.
 */
public class AccountEJB implements AccountInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    @Override
    public void createAccount(Account account) throws CreateException {
        try {
            em.persist(account);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateAccount(Account account) throws UpdateException {
        try {
            if (!em.contains(account)) {
                em.merge(account);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteAccount(Account account) throws DeleteException {
        try {
            em.remove(em.merge(account));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Account> viewAllAccounts() throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("viewAllAccounts").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> searchAllAccountsByUser(String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("searchAllAccountsByUser").setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsByName(String name) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByName").setParameter("name", name).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsByDescription(String description) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByDescription").setParameter("description", description).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsWithHigherBalance(String balance) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithHigherBalance").setParameter("balance", balance).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsWithLowerBalance(String balance) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithLowerBalance").setParameter("balance", balance).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsByDivisa(String divisa) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByDivisa").setParameter("divisa", divisa).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

}
