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
 *
 * @author Jason.
 */
@Entity
@DiscriminatorValue("Recurrent")
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
