package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Account;

/**
 *
 * @author Jessica.
 */
public interface AccountInterface {

    public void createAccount(Account account) throws CreateException;

    public void updateAccount(Account account) throws UpdateException;

    public void deleteAccount(Account account) throws DeleteException;

    public Account findAccount(Long id) throws SelectException;

    public List<Account> viewAllAccounts() throws SelectException;

    public List<Account> searchAllAccountsByUser(String mail) throws SelectException;

    public List<Account> filterAccountsByName(String name) throws SelectException;

    public List<Account> filterAccountsByDescription(String description) throws SelectException;

    public List<Account> filterAccountsWithHigherBalance(String balance) throws SelectException;

    public List<Account> filterAccountsWithLowerBalance(String balance) throws SelectException;

    public List<Account> filterAccountsByDivisa(String divisa) throws SelectException;
}
