package model.entitys;

import model.enums.Category;
import model.enums.Period;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Es la entidad Recurrent.
 *
 * @author Jason.
 */
@Entity
@DiscriminatorValue("Recurrent")
@NamedQueries({
    @NamedQuery(
            name = "listAllRecurrents", query = "SELECT R FROM Recurrent R"
    )
    ,
    @NamedQuery(
            name = "findRecurrent", query = "SELECT R FROM Recurrent R WHERE R.uuid = :uuid"
    )
    ,
    @NamedQuery(
            name = "findRecurrentsByAccount", query = "SELECT R FROM Recurrent R WHERE R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsByName", query = "SELECT R FROM Recurrent R WHERE R.name like :name AND R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsByConcept", query = "SELECT R FROM Recurrent R WHERE R.concept like :concept AND R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsWithHigherAmount", query = "SELECT R FROM Recurrent R WHERE R.amount >= :amount AND R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsWithLowerAmount", query = "SELECT R FROM Recurrent R WHERE R.amount <= :amount AND R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsByPeriodicity", query = "SELECT R FROM Recurrent R WHERE R.periodicity = :periodicity AND R.account.id = :id"
    )
    ,
    @NamedQuery(
            name = "filterRecurrentsByCategory", query = "SELECT R FROM Recurrent R WHERE R.category = :category AND R.account.id = :id"
    ),})
@XmlRootElement
public class Recurrent extends Expense implements Serializable {

    private static final long serialVersionUID = 11L;

    //******************** ATRIBUTOS *********************/
    @Enumerated(EnumType.STRING)
    private Period periodicity;

    @Enumerated(EnumType.STRING)
    private Category category;

    //******************** CONSTRUCTOR *********************/
    public Recurrent() {
        super();
    }

    //******************** GETTERS && SETTERS *********************/
    public Period getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Period periodicity) {
        this.periodicity = periodicity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //******************** METODOS *********************/
    @Override
    public String toString() {
        return super.toString() + "Recurrent{" + "periodicity=" + periodicity + ", category=" + category + '}';
    }

}
