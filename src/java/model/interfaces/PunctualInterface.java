package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Punctual;
import model.enums.Importance;

/**
 * Es la interfaz de la entidad Punctual.
 *
 * @author Ian.
 */
public interface PunctualInterface {

    /**
     * Crea un Punctual en la base de datos.
     *
     * @param punctual el Punctual que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    public void createPunctual(Punctual punctual) throws CreateException;

    /**
     * Modifica un Punctual de la base de datos.
     *
     * @param punctual el Punctual con los datos que se van a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    public void updatePunctual(Punctual punctual) throws UpdateException;

    /**
     * Elimina un Punctual de la base de datos.
     *
     * @param punctual el Punctual que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    public void deletePunctual(Punctual punctual) throws DeleteException;

    /**
     * Busca todos los Punctuals de la base de datos.
     *
     * @return todos los Punctuals y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> listAllPunctuals() throws SelectException;

    /**
     * Busca un Punctual por id.
     *
     * @param id el identificador unico del Punctual.
     * @return todos los datos del Punctual.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public Punctual findPunctual(Long id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Punctual del Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> findPunctualsByAccount(Long id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account que tengan ciertos caracteres en
     * su nombre.
     *
     * @param name los caraceres que queramos que tenga en el nombre.
     * @param account_id el identificador unico del Account.
     * @return todos los Punctual que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> filterPunctualsByName(String name, Long account_id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account que tengan ciertos caracteres en
     * su concepto.
     *
     * @param concept los caraceres que queramos que tenga en el concepto.
     * @param account_id el identificador unico del Account.
     * @return todos los Punctual que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> filterPunctualsByConcept(String concept, Long account_id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account que tengan un amount mayor al
     * especificado.
     *
     * @param amount el amount que quermos que supere.
     * @param account_id el identificador unico del Account.
     * @return todos los Punctual que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> filterPunctualsWithHigherAmount(Float amount, Long account_id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account que tengan un amount menor al
     * especificado.
     *
     * @param amount el amount que queremos no queremos que supere.
     * @param account_id el identificador unico del Account.
     * @return todos los Punctual que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> filterPunctualsWithLowerAmount(Float amount, Long account_id) throws SelectException;

    /**
     * Busca todos los Punctual de un Account que tengan una Importance
     * especifico.
     *
     * @param importance el Importance que queremos que tenga.
     * @param account_id el identificador unico del Account.
     * @return todos los Punctual que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Punctual> filterPunctualsByImportance(Importance importance, Long account_id) throws SelectException;

}
