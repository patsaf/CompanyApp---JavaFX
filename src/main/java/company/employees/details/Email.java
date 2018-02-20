package company.employees.details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.regex.Pattern;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String email;

    public Email() { email = null; }

    public Email(String email) {
        if (Pattern.matches("[\\.a-z0-9_-]+@[a-z]+\\.[a-z]{2,3}", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() { return email; }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Email)){
            return false;
        }

        Email e = (Email) o;
        return Objects.equals(email, e.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
