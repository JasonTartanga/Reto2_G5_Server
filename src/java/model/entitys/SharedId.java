package model.entitys;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jason.
 */
@Embeddable
public class SharedId implements Serializable {

    private String id;
    private String mail;

}
