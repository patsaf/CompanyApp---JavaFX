package company.employees;

import company.employees.details.*;
import company.tasks.TaskList;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractEmployee implements Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private final EmployeeType type;
    @OneToOne(cascade = CascadeType.ALL)
    private final EmployeeRole role;
    @OneToOne(cascade = CascadeType.ALL)
    private final FirstName firstName;
    @OneToOne(cascade = CascadeType.ALL)
    private final LastName lastName;
    @OneToOne(cascade = CascadeType.ALL)
    private final University university;
    @OneToOne(cascade = CascadeType.ALL)
    private final Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    private final Country country;
    @OneToOne(cascade = CascadeType.ALL)
    private final Email email;
    private int unitsOfWork;
    @OneToOne(cascade = CascadeType.ALL)
    private final TaskList taskList;

    public AbstractEmployee() {
        type = null;
        role = null;
        firstName = null;
        lastName = null;
        university = null;
        gender = null;
        country = null;
        email = null;
        taskList = null;
    }

    public AbstractEmployee(Builder builder) {
        this.type = builder.type;
        this.role = builder.role;
        this.university = builder.university;
        this.country = builder.country;
        this.gender = builder.gender;
        unitsOfWork = 0;
        taskList = new TaskList();
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
    }

    @Override
    public EmployeeType getType() {
        return type;
    }

    @Override
    public EmployeeRole getRole() {
        return role;
    }

    @Override
    public int getUnitsOfWork() {
        return unitsOfWork;
    }

    protected void setUnitsOfWork(int i) {
        unitsOfWork += i;
    }

    @Override
    public TaskList getTaskList() { return taskList;  }

    @Override
    public FirstName getFirstName() { return firstName; }

    @Override
    public LastName getLastName() { return lastName; }

    @Override
    public University getUniversity() { return university; }

    @Override
    public Gender getGender() { return gender; }

    @Override
    public Country getCountry() { return country; }

    @Override
    public Email getEmail() { return email; }

    @Override
    public String toString() {
        return role.name() + " { "  + firstName +
                " " + lastName + ", " + gender + ", " + email +
                ", " + country + ", " + university + " }\n";
    }

    public static abstract class Builder<T extends Builder<T>> {

        private  EmployeeType type;
        private  EmployeeRole role;
        private  FirstName firstName;
        private  LastName lastName;
        private  University university;
        private  Gender gender;
        private  Country country;
        private  Email email;

        protected abstract T self();

        public Builder(EmployeeType type, EmployeeRole role) {
            this.role = role;
            this.type = type;
        }

        public T name(FirstName firstName, LastName lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            return self();
        }

        public T university(University university) {
            this.university = university;
            return self();
        }

        public T gender(Gender gender) {
            this.gender = gender;
            return self();
        }

        public T country(Country country) {
            this.country = country;
            return self();
        }

        public T email(Email email) {
            this.email = email;
            return self();
        }

        public abstract Employee build();
    }
}

