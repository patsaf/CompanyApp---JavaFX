package company.employees.details;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String country;

    public Country() { country = null; }

    public Country(String country) { this.country = country; }

    public String toString() { return country; }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Country)){
            return false;
        }

        Country c = (Country) o;
        return Objects.equals(country, c.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }
}
