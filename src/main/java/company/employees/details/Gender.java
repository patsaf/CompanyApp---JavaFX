package company.employees.details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum Gender {
    FEMALE, MALE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
