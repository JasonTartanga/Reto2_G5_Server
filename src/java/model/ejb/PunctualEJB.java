package model.ejb;

import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.SelectException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entitys.Punctual;
import model.enums.Importance;
import model.interfaces.PunctualInterface;

/**
 * Es el EJB de la entidad Punctual.
 *
 * @author Ian.
 */
@Stateless
public class PunctualEJB implements PunctualInterface {

    @PersistenceContext(unitName = "Reto2_G5_ServerPU")
    private EntityManager em;

    /**
     * Crea un Punctual en la base de datos.
     *
     * @param punctual el Punctual que se va a guardar.
     * @throws CreateException gestiona una excepcion a la hora de crear
     * entidades.
     */
    @Override
    public void createPunctual(Punctual punctual) throws CreateException {
        try {
            punctual.setUuid(null);
            em.persist(punctual);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Modifica un Punctual de la base de datos.
     *
     * @param punctual el Punctual con los datos que se van a modificar.
     * @throws UpdateException gestiona una excepcion a la hora de modificar
     * entidades.
     */
    @Override
    public void updatePunctual(Punctual punctual) throws UpdateException {
        try {
            if (!em.contains(punctual)) {
                em.merge(punctual);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    /**
     * Elimina un Punctual de la base de datos.
     *
     * @param punctual el Punctual que se va a eliminar.
     * @throws DeleteException gestiona una excepcion a la hora de eliminar
     * entidades.
     */
    @Override
    public void deletePunctual(Punctual punctual) throws DeleteException {
        try {
            em.remove(em.merge(punctual));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Busca todos los Punctuals de la base de datos.
     *
     * @return todos los Punctuals y sus datos.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Punctual> listAllPunctuals() throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("listAllPunctuals").getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

    /**
     * Busca un Punctual por id.
     *
     * @param id el identificador unico del Punctual.
     * @return todos los datos del Punctual.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public Punctual findPunctual(Long id) throws SelectException {
        Punctual p = null;
        try {
            p = em.find(Punctual.class, id);
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return p;
    }

    /**
     * Busca todos los Punctual de un Account.
     *
     * @param id el identificador unico del Account.
     * @return todos los Punctual del Account.
     * @throws SelectException gestiona una excepcion a la hora de buscar
     * entidades.
     */
    @Override
    public List<Punctual> findPunctualsByAccount(Long id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("findPunctualsByAccount").setParameter("id", id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

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
    @Override
    public List<Punctual> filterPunctualsByName(String name, Long account_id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByName").setParameter("name", "%" + name + "%").setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

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
    @Override
    public List<Punctual> filterPunctualsByConcept(String concept, Long account_id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByConcept").setParameter("concept", "%" + concept + "%").setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

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
    @Override
    public List<Punctual> filterPunctualsWithHigherAmount(Float amount, Long account_id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsWithHigherAmount").setParameter("amount", amount).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

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
    @Override
    public List<Punctual> filterPunctualsWithLowerAmount(Float amount, Long account_id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsWithLowerAmount").setParameter("amount", amount).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }

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
    @Override
    public List<Punctual> filterPunctualsByImportance(Importance importance, Long account_id) throws SelectException {
        List<Punctual> punctuals = null;
        try {
            punctuals
                    = em.createNamedQuery("filterPunctualsByImportance").setParameter("importance", importance).setParameter("id", account_id).getResultList();
        } catch (Exception e) {
            throw new SelectException(e.getMessage());
        }
        return punctuals;
    }
}
