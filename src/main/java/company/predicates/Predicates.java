package company.predicates;

import org.omg.CORBA.portable.IDLEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum Predicates {
    EMPTY, UNIVERSITY, GENDER, COUNTRY, EMAIL;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
