package model.entitys;

import model.enums.Permissions;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Es la entidad que permite la union ManyToMany entre User y Account.
 *
 * @author Jason, Jessica.
 */
@Entity
@Table(name = "Shared", schema = "CashTracker")
@NamedQueries({
    @NamedQuery(
            name = "findShared", query = "SELECT S FROM Shared S WHERE S.account.id = :id AND S.user.mail = :mail"
    )
    ,
    @NamedQuery(
            name = "findAllShared", query = "SELECT S FROM Shared S"
    ),})
@XmlRootElement
public class Shared implements Serializable {

    private static final long serialVersionUID = 1L;

    //******************** ATRIBUTOS *********************/
    @EmbeddedId
    private SharedId idShared;

    @MapsId("accountId")
    @ManyToOne
    private Account account;

    @MapsId("userMail")
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Permissions permissions;

    //******************** GETTERS && SETTERS *********************/
    public SharedId getIdShared() {
        return idShared;
    }

    public void setIdShared(SharedId idShared) {
        this.idShared = idShared;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Shared{" + "idShared=" + idShared + ", account=" + account + ", user=" + user + ", permissions=" + permissions + '}';
    }

}
