package company.employees.details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.regex.Pattern;

@Entity
public class LastName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String lastName;

    public LastName() { lastName = null; }

    public LastName(String lastName) {
        if (Pattern.matches("[A-Z][a-z]+", lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() { return lastName; }
}
