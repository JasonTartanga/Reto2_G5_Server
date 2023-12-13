/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entitys;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Ian.
 */
@Entity
@DiscriminatorValue("Punctual")
public class Punctual extends Expense implements Serializable {

    private static final long serialVersionUID = 11L;

    @Enumerated(EnumType.ORDINAL)
    private Importance importance;

    public Punctual() {
        super();
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Punctual{" + "importance=" + importance + '}';
    }

}
