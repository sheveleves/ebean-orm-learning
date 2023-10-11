package Model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Sh extends Model {
    @Id
    private long id;
    @Lob
    private String first_name;
    @Lob
    private String last_name;

    public Sh(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Sh{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
