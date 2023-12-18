package model.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian.
 */
@Entity
@Table(name = "Expense", schema = "CashTracker")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;

    //******************** ATRIBUTOS *********************/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    private String name;
    private String concept;
    private float amount;
    private float totalPuntual;
    private float totalRecurrente;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Account account;

    //******************** GETTERS && SETTERS *********************/
    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account group) {
        this.account = group;
    }

    public float getTotalPuntual() {
        return totalPuntual;
    }

    public void setTotalPuntual(float totalPuntual) {
        this.totalPuntual = totalPuntual;
    }

    public float getTotalRecurrente() {
        return totalRecurrente;
    }

    public void setTotalRecurrente(float totalRecurrente) {
        this.totalRecurrente = totalRecurrente;
    }

    //******************** METODOS *********************/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expense)) {
            return false;
        }
        Expense other = (Expense) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expense{" + "uuid=" + uuid + ", name=" + name + ", concept=" + concept + ", amount=" + amount + ", totalPuntual=" + totalPuntual + ", totalRecurrente=" + totalRecurrente + ", date=" + date + ", account=" + account + '}';
    }

}
