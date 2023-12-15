package model.entitys;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jason.
 */
@Embeddable
public class SharedId implements Serializable {

    //******************** ATRIBUTOS *********************/
    private String id;
    private String mail;

    //******************** GETTERS && SETTERS *********************/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
