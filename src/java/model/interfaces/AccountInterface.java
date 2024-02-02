package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Account;
import model.enums.Divisa;
import model.enums.Plan;

/**
 * Esta es la interfaz para la entidad Account.
 *
 * @author Jessica.
 */
public interface AccountInterface {

    /**
     * Crea un Account en la base de datos.
     *
     * @param account el Account que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    public void createAccount(Account account) throws CreateException;

    /**
     * Modifica un Account de la base de datos.
     *
     * @param account el Account que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    public void updateAccount(Account account) throws UpdateException;

    /**
     * Elimina un Account de la base de datos.
     *
     * @param account el Account que se ba a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    public void deleteAccount(Account account) throws DeleteException;

    /**
     * Busca un Account por id.
     *
     * @param id identificador unico del Account.
     * @return el Account y todos sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public Account findAccount(Long id) throws SelectException;

    /**
     * Busca todos los Accounts que hay en la base de datos.
     *
     * @return todos los Accounts con todos sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> viewAllAccounts() throws SelectException;

    /**
     * Busca todos los Account de un usuario.
     *
     * @param mail el identificador unico del user.
     * @return todos los Accounts y sus datos de un usuario.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> findAllAccountsByUser(String mail) throws SelectException;

    /**
     * Busca todos los Accounts por nombre o que contengan una porcion en su
     * nombre.
     *
     * @param name el nombre una porcion del nombre del Account que buscamos.
     * @param mail el identificador unico del usuario.
     * @return todos los Account que se llamen o contengan esa porcion en su
     * nombre.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsByName(String name, String mail) throws SelectException;

    /**
     * Busca todos los Accounts por descripcion o que contengan una porcion en
     * su descripcion.
     *
     * @param description la descripcion o una porcion de la descripcion del
     * Account que buscamos.
     * @param mail el identificador unico del usuario.
     * @return todos los Account que se llamen o contengan esa porcion en su
     * descripcion.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsByDescription(String description, String mail) throws SelectException;

    /**
     * Busca todos los Accounts que tengan un mayor balance al especificado.
     *
     * @param balance el balance que queramos que supere.
     * @param mail el identificador unico del usuario.
     * @return todos los Account que tengan mayor balance al espeficicado.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsWithHigherBalance(Float balance, String mail) throws SelectException;

    /**
     * Busca todos los Accounts que tengan un menor balance al especificado.
     *
     * @param balance el balance que queramos que sea inferior.
     * @param mail el identificador unico del usuario.
     * @return todos los Account que tengan menor balance al espeficicado.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsWithLowerBalance(Float balance, String mail) throws SelectException;

    /**
     * Busca todos los Accounts que tengan la misma divisa al especificado.
     *
     * @param divisa la divisa del Account que buscamos.
     * @param mail mail del usuario
     * @return todos los Account que usen esa divisa.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsByDivisa(Divisa divisa, String mail) throws SelectException;

    /**
     *
     * @param plan la enumeracion del plan
     * @param mail el email del usuario
     * @return Todos los account que usen ese plan
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Account> filterAccountsByPlan(Plan plan, String mail) throws SelectException;

    public Long countAccount() throws SelectException;
}
