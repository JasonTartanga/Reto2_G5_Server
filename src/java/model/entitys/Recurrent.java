package model.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Jason.
 */
@Entity
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
