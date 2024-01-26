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
    private Long id;
    private String mail;

    //******************** GETTERS && SETTERS *********************/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.mail);
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
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SharedId{" + "id=" + id + ", mail=" + mail + '}';
    }

}
