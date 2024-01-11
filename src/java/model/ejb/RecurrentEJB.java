package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Recurrent;
import model.enums.Category;
import model.enums.Period;
import model.interfaces.RecurrentInterface;

/**
 * Es el EJB de la entidad Recurrent.
 *
 * @author Jason.
 */
@Stateless
public class RecurrentEJB implements RecurrentInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(RecurrentEJB.class.getName());

    /**
     * Crea un Recurrent en la base de datos.
     *
     * @param recurrent el Recurrent que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @Override
    public void createRecurrent(Recurrent recurrent) throws CreateException {
        try {
            em.persist(recurrent);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Modifica un recurrent de la base de datos.
     *
     * @param recurrent el Recurent con los datos que se van a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
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

    /**
     * Elimina un Recurrent de la base de datos.
     *
     * @param recurrent el Recurrent que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    @Override
    public void deleteRecurrent(Recurrent recurrent) throws DeleteException {
        try {
            log.warning("Delete Recurrent --> " + recurrent.getUuid());

            //  recurrent.setAccount(null);
            //  this.updateRecurrent(recurrent);
            em.remove(em.merge(recurrent));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Busca todos los Recurrents de la base de datos.
     *
     * @return todos los Recurrents y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Recurrent> listAllRecurrents() throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("listAllRecurrents").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    /**
     * Busca un Recurrent por id.
     *
     * @param id el identificador unico del Recurrent.
     * @return todos los datos del Recurrent.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Recurrent findRecurrent(Long id) throws SelectException {
        Recurrent r = null;
        try {
            r = em.find(Recurrent.class, id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return r;
    }

    /**
     * Busca todos los Recurrent de un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Recurrent del Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Recurrent> findRecurrentsByAccount(Long id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("findRecurrentsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

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
    @Override
    public List<Recurrent> filterRecurrentsByName(String name, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByName").setParameter("name", "%" + name + "%").setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

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
    @Override
    public List<Recurrent> filterRecurrentsByConcept(String concept, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByConcept").setParameter("concept", "%" + concept + "%").setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

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
    @Override
    public List<Recurrent> filterRecurrentsWithHigherAmount(Float amount, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsWithHigherAmount").setParameter("amount", amount).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

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
    @Override
    public List<Recurrent> filterRecurrentsWithLowerAmount(Float amount, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsWithLowerAmount").setParameter("amount", amount).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    /**
     * Busca todos los Recurrent de un Account que tengan una Period especifico.
     *
     * @param periodicity el Period que queremos que tenga.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Recurrent> filterRecurrentsByPeriodicity(Period periodicity, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByPeriodicity").setParameter("periodicity", periodicity).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }

    /**
     * Busca todos los Recurrent de un Account que tenga un Category especifico.
     *
     * @param category el Category que queramos que tenga.
     * @param account_id el identificador unico del Account.
     * @return todos los Recurrent que cumplan con los criterios anteriores.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Recurrent> filterRecurrentsByCategory(Category category, Long account_id) throws SelectException {
        List<Recurrent> recurrents = null;
        try {
            recurrents
                    = em.createNamedQuery("filterRecurrentsByCategory").setParameter("category", category).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return recurrents;
    }
}
