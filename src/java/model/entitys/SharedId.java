package model.entitys;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 * Esta clase es para hacer el EmbeddableId de Shared.
 *
 * @author Jason, Jessica.
 */
@Embeddable
public class SharedId implements Serializable {

    //******************** ATRIBUTOS *********************/
    private Long accountId;
    private String userMail;

    //******************** GETTERS && SETTERS *********************/
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.accountId);
        hash = 31 * hash + Objects.hashCode(this.userMail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SharedId other = (SharedId) obj;
        if (!Objects.equals(this.userMail, other.userMail)) {
            return false;
        }
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SharedId{" + "accountId=" + accountId + ", userMail=" + userMail + '}';
    }

}
