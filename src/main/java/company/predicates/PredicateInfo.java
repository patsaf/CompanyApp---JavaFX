package company.predicates;

import javax.persistence.*;

@Entity
public class PredicateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String conditionDetails;

    @Enumerated(EnumType.STRING)
    private final Predicates conditionName;

    public PredicateInfo() {
        conditionName = null;
        conditionDetails = null;
    }

    public PredicateInfo(Predicates conditionName, String conditionDetails) {
        this.conditionDetails = conditionDetails;
        this.conditionName = conditionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConditionDetails() {
        return conditionDetails;
    }

    public Predicates getConditionName() {
        return conditionName;
    }

    public String toString() {
        String output = "";
        switch(conditionName) {
            case EMAIL:
                output = "This manager employs developers only with " + conditionDetails + " email domain";
                break;
            case GENDER:
                output =  "This manager employs only " + conditionDetails + " developers";
                break;
            case COUNTRY:
                output =  "This manager employs only developers from " + conditionDetails;
                break;
            case UNIVERSITY:
                output = "This manager employs only " + conditionDetails + " graduates";
                break;
        }
        return output + "\n";
    }
}
