package model.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Ian.
 */
@Entity
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
