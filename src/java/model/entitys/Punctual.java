package model.entitys;

import model.enums.Importance;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian.
 */
@Entity
@DiscriminatorValue("Punctual")
@NamedQueries({
    @NamedQuery(
            name = "listAllPunctuals", query = "SELECT P FROM Punctual P"
    )
    ,
    @NamedQuery(
            name = "findPunctual", query = "SELECT P FROM Punctual P WHERE P.uuid = :uuid"
    )
    ,
    @NamedQuery(
            name = "findPunctualsByAccount", query = "SELECT P FROM Punctual P WHERE P.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterPunctualsByName", query = "SELECT P FROM Punctual P WHERE P.name like :name"
    )
    ,
    @NamedQuery(
            name = "filterPunctualsByConcept", query = "SELECT P FROM Punctual P WHERE P.concept like :concept"
    )
    ,
    @NamedQuery(
            name = "filterPunctualsWithHigherAmount", query = "SELECT P FROM Punctual P WHERE P.amount >= :amount"
    )
    ,
    @NamedQuery(
            name = "filterPunctualsWithLowerAmount", query = "SELECT P FROM Punctual P WHERE P.amount <= :amount"
    )
    ,@NamedQuery(
            name = "filterPunctualsByImportance", query = "SELECT P FROM Punctual P WHERE P.importance = :importance"
    ),})
@XmlRootElement
public class Punctual extends Expense implements Serializable {

    private static final long serialVersionUID = 11L;

    //******************** ATRIBUTOS *********************/
    @Enumerated(EnumType.STRING)
    private Importance importance;

    //******************** CONSTRUCTOR *********************/
    public Punctual() {
        super();
    }

    //******************** GETTERS && SETTERS *********************/
    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    //******************** METODOS *********************/
    @Override
    public String toString() {
        return "Punctual{" + "importance=" + importance + '}';
    }

}
