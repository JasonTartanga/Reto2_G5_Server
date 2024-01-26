package model.interfaces;

import exceptions.CreateException;
import exceptions.CredentialErrorException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import model.entitys.User;

/**
 * Es la interfaz de la entidad User.
 *
 * @author Ian.
 */
public interface UserInterface {

    /**
     * Crea un usuario en la base de datos.
     *
     * @param user el usuario que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    public void createUser(User user) throws CreateException;

    /**
     * Modifica un usuario de la base de datos.
     *
     * @param user el usuario que se va a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    public void updateUser(User user) throws UpdateException;

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param user el usuario que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    public void deleteUser(User user) throws DeleteException;

    /**
     * Busca un usuario por su mail.
     *
     * @param mail el identificador unico del usuario.
     * @return todos los datos del usuario.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public User findUser(String mail) throws SelectException;

    /**
     * Busca todos los usuario de la base de datos.
     *
     * @return todos los usuarios.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    public List<User> viewAllUser() throws SelectException;

    /**
     * Mira en la base de datos si un usuario contiene el mail y la contraseña,
     * si coinciden devuelve el todos datos del usuario, si no devuelve null
     *
     * @param mail el identificador unico del usuario.
     * @param passwd la contraseña del usuario.
     * @return todos los datos del usuario o null.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     * @throws exceptions.CredentialErrorException gestiona una excepcion por si
     * no se encuentra el usuario con la contraseña.
     */
    public User loginUser(String mail, String passwd) throws SelectException, CredentialErrorException;

}
