package model.interfaces;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.Shared;

/**
 * Es la interfaz de la entidad Shared.
 *
 * @author Jason, Jessica.
 */
public interface SharedInterface {

    /**
     * Crea un Shared en la base de datos.
     *
     * @param shared el Shared que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    public void createShared(Shared shared) throws CreateException;

    /**
     * Modifica un Shared de la base de datos.
     *
     * @param shared los datos del Shared que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    public void updateShared(Shared shared) throws UpdateException;

    /**
     * Elimina un Shared de la base de datos.
     *
     * @param shared los datos del Shared que se van a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    public void deleteShared(Shared shared) throws DeleteException;

    /**
     * Busca un Shared en la base de datos.
     *
     * @param account_id el identificado unico del Account.
     * @param mail el identificador unico del User.
     * @return todos los datos del Shared.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public Shared findShared(Long account_id, String mail) throws SelectException;

    /**
     * Busca todos los Shared de la base de datos.
     *
     * @return todos los Shared y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<Shared> findAllShared() throws SelectException;
}
