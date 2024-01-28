package model.entitys;

import model.enums.Privileges;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Es la entidad de usuario.
 *
 * @author Ian.
 */
@Entity
@Table(name = "User", schema = "CashTracker")
@NamedQueries({
    @NamedQuery(
            name = "viewAllUsers", query = "SELECT U FROM User U"
    )
    ,
    @NamedQuery(
            name = "loginUser", query = "SELECT U FROM User U WHERE mail = :mail AND password = :password"
    ),})
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 11L;

    //******************** ATRIBUTOS *********************/
    @Id
    private String mail;
    private String name;
    private String address;
    private String password;
    private int phone;
    private int zip;

    @Enumerated(EnumType.STRING)
    private Privileges privileges;

    //@OneToMany(cascade = ALL, mappedBy = "user", orphanRemoval = true)
    @OneToMany(cascade = ALL, mappedBy = "user")
    private List<Shared> shared;

    //******************** GETTERS && SETTERS *********************/
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }

    @XmlTransient
    public List<Shared> getShared() {
        return shared;
    }

    public void setShared(List<Shared> shared) {
        this.shared = shared;
    }

    //******************** METODOS *********************/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mail != null ? mail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.mail == null && other.mail != null) || (this.mail != null && !this.mail.equals(other.mail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "mail=" + mail + ", name=" + name + ", address=" + address + ", password=" + password + ", phone=" + phone + ", zip=" + zip + ", privileges=" + privileges + '}';
    }
}
