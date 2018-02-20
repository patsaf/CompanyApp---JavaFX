package company.employees.details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String university;

    public University() { university = null; }

    public University(String university) { this.university = university; }

    public String toString() { return university; }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof University)){
            return false;
        }

        University u = (University) o;
        return Objects.equals(university, u.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(university);
    }
}
