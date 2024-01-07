package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Recurrent;
import model.enums.Category;
import model.enums.Period;

/**
 * Es la interfaz de la entidad Recurrent.
 *
 * @author Jason.
 */
public interface RecurrentInterface {

    /**
     * Crea un Recurrent en la base de datos.
     *
     * @param recurrent el Recurrent que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    public void createRecurrent(Recurrent recurrent) throws CreateException;

    /**
     * Modifica un recurrent de la base de datos.
     *
     * @param recurrent el Recurent con los datos que se van a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    public void updateRecurrent(Recurrent recurrent) throws UpdateException;

    /**
     * Elimina un Recurrent de la base de datos.
     *
     * @param recurrent el Recurrent que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    public void deleteRecurrent(Recurrent recurrent) throws DeleteException;

    /**
     * Busca todos los Recurrents de la base de datos.
     *
     * @return todos los Recurrents y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> listAllRecurrents() throws SelectException;

    /**
     * Busca un Recurrent por id.
     *
     * @param id el identificador unico del Recurrent.
     * @return todos los datos del Recurrent.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public Recurrent findRecurrent(Long id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Recurrent del Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> findRecurrentsByAccount(Long id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tengan ciertos caracteres en
     * su nombre.
     *
     * @param name los caraceres que queramos que tenga en el nombre.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsByName(String name, Long account_id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tengan ciertos caracteres en
     * su concepto.
     *
     * @param concept los caraceres que queramos que tenga en el concepto.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsByConcept(String concept, Long account_id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tengan un amount mayor al
     * especificado.
     *
     * @param amount el amount que quermos que supere.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsWithHigherAmount(Float amount, Long account_id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tengan un amount menor al
     * especificado.
     *
     * @param amount el amount que queremos no queremos que supere.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsWithLowerAmount(Float amount, Long account_id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tengan una Period especifico.
     *
     * @param periodicity el Period que queremos que tenga.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsByPeriodicity(Period periodicity, Long account_id) throws SelectException;

    /**
     * Busca todos los Recurrent de un Account que tenga un Category especifico.
     *
     * @param category el Category que queramos que tenga.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Recurrent> filterRecurrentsByCategory(Category category, Long account_id) throws SelectException;

}
