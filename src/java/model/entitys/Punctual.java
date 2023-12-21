package model.entitys;

import model.enums.Importance;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian.
 */
@Entity
@DiscriminatorValue("Punctual")
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
