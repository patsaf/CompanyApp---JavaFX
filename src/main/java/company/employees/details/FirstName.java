package company.employees.details;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
public class FirstName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String firstName;

    public FirstName() { firstName = null; }

    public FirstName(String firstName) {
        if (Pattern.matches("[A-Z][a-z]+", firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() { return firstName; }
}
