package model.entitys;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Jason.
 */
@Entity
@Table(name = "Shared", schema = "CashTraker")
public class Shared implements Serializable {

    private static final long serialVersionUID = 1L;

    //******************** ATRIBUTOS *********************/
    @EmbeddedId
    private SharedId idShared;

    @MapsId("id")
    @ManyToOne
    private Group group;

    @MapsId("mail")
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

    public Group getBankAccount() {
        return group;
    }

    public void setBankAccount(Group group) {
        this.group = group;
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
}
