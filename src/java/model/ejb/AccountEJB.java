package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Account;
import model.entitys.Expense;
import model.enums.Divisa;
import model.enums.Plan;
import model.interfaces.AccountInterface;

/**
 * Es el EJB de la entidad Account.
 *
 * @author Jessica.
 */
@Stateless
public class AccountEJB implements AccountInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    /**
     * Crea un Account en la base de datos.
     *
     * @param account el Account que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @Override
    public void createAccount(Account account) throws CreateException {
        try {
            account.setId(null);
            em.persist(account);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Modifica un Account de la base de datos.
     *
     * @param account el Account que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
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

    /**
     * Elimina un Account de la base de datos.
     *
     * @param account el Account que se ba a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    @Override
    public void deleteAccount(Account account) throws DeleteException {
        try {
            for (Expense r : account.getExpenses()) {
                em.remove(em.merge(r));
            }

            em.remove(em.merge(account));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Busca un Account por id.
     *
     * @param id identificador unico del Account.
     * @return el Account y todos sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Account findAccount(Long id) throws SelectException {
        Account a = null;

        try {
            a = em.find(Account.class,
                     id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return a;
    }

    /**
     * Busca todos los Accounts que hay en la base de datos.
     *
     * @return todos los Accounts con todos sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
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

    /**
     * Busca todos los Account de un usuario.
     *
     * @param mail el identificador unico del user.
     * @return todos los Accounts y sus datos de un usuario.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> findAllAccountsByUser(String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("findAllAccountsByUser").setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    /**
     * Busca todos los Accounts por nombre o que contengan una porcion en su
     * nombre.
     *
     * @param name el nombre una porcion del nombre del Account que buscamos.
     * @return todos los Account que se llamen o contengan esa porcion en su
     * nombre.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsByName(String name, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByName").setParameter("name", "%" + name + "%").setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    /**
     * Busca todos los Accounts por descripcion o que contengan una porcion en
     * su descripcion.
     *
     * @param description la descripcion o una porcion de la descripcion del
     * Account que buscamos.
     * @return todos los Account que se llamen o contengan esa porcion en su
     * descripcion.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsByDescription(String description, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByDescription").setParameter("description", "%" + description + "%").setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    /**
     * Busca todos los Accounts que tengan un mayor balance al especificado.
     *
     * @param balance el balance que queramos que supere.
     * @return todos los Account que tengan mayor balance al espeficicado.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsWithHigherBalance(Float balance, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithHigherBalance").setParameter("balance", balance).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    /**
     * Busca todos los Accounts que tengan un menor balance al especificado.
     *
     * @param balance el balance que queramos que sea inferior.
     * @return todos los Account que tengan menor balance al espeficicado.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsWithLowerBalance(Float balance, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithLowerBalance").setParameter("balance", balance).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    
    /**
     * Busca todos los Accounts que tengan un balance igual al especificado.
     * @param balance el balance que queramos que sea inferior
     * @return todos los Account que tengan igual balance al espeficicado
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsWithEqualBalance(Float balance, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithEqualBalance").setParameter("balance", balance).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }
    
    
    @Override
    public List<Account> filterAccountsWithDateAfter(Date date, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithDateAfter").setParameter("date", date).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }
    
      @Override
    public List<Account> filterAccountsWithDateEquals(Date date, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithDateEquals").setParameter("date", date).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

      @Override
    public List<Account> filterAccountsWithDateBefore(Date date, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsWithDateBefore").setParameter("date", date).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }
    
    /**
     *
     * Busca todos los Accounts que tengan la misma divisa al especificado.
     *
     * @param divisa la divisa del Account que buscamos.
     * @return todos los Account que usen esa divisa.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Account> filterAccountsByDivisa(Divisa divisa, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByDivisa").setParameter("divisa", divisa).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public List<Account> filterAccountsByPlan(Plan plan, String mail) throws SelectException {
        List<Account> accounts = null;
        try {
            accounts
                    = em.createNamedQuery("filterAccountsByPlan").setParameter("plan", plan).setParameter("mail", mail).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public Long countAccount() throws SelectException {
        Long id = null;
        try {
            id = (Long) em.createNamedQuery("countAccount").getSingleResult();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return id;
    }
}
