package model.entitys;

import model.enums.Plan;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Es la entidad Account.
 *
 * @author Jessica.
 */
@Entity
@Table(name = "Account", schema = "CashTracker")
@NamedQueries({
    @NamedQuery(
            name = "viewAllAccounts", query = "SELECT A FROM Account A"
    )
    ,
   @NamedQuery(
            name = "findAllAccountsByUser", query = "SELECT A FROM Account A JOIN A.shared S WHERE S.user.mail = :mail"
    )
    ,
        @NamedQuery(
            name = "filterAccountsByName", query = "SELECT A FROM Account A WHERE A.name like :name"
    )
    ,
    @NamedQuery(
            name = "filterAccountsByDescription", query = "SELECT A FROM Account A WHERE A.description like :description"
    )
    ,
    @NamedQuery(
            name = "filterAccountsWithHigherBalance", query = "SELECT A FROM Account A WHERE A.balance >= :balance"
    )
    ,
    @NamedQuery(
            name = "filterAccountsWithLowerBalance", query = "SELECT A FROM Account A WHERE A.balance <= :balance"
    )
    ,
    @NamedQuery(
            name = "filterAccountsByDivisa", query = "SELECT A FROM Account A WHERE A.divisa = :divisa"
    ),})
@XmlRootElement
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    //******************** ATRIBUTOS *********************/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String divisa;
    private Float balance;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Plan plan;

    @OneToMany(cascade = ALL, mappedBy = "account", orphanRemoval = true)
    private List<Shared> shared;

    @OneToMany(cascade = ALL, mappedBy = "account", orphanRemoval = true)
    private List<Expense> expenses;

    //******************** GETTERS && SETTERS *********************/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @XmlTransient
    public List<Shared> getShared() {
        return shared;
    }

    public void setShared(List<Shared> shared) {
        this.shared = shared;
    }

    @XmlTransient
    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    //******************** METODOS *********************/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", nombre=" + name + ", description=" + description + ", divisa=" + divisa + ", balance=" + balance + ", date=" + date + ", plan=" + plan + ", shared=" + shared + ", expenses=" + expenses + '}';
    }

}
