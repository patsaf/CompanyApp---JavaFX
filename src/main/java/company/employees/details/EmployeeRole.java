package company.employees.details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum EmployeeRole {
    CEO, DEVELOPMENT_MANAGER, TESTER, DEVELOPER, CONTRIBUTOR, TEAM_LEADER;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
