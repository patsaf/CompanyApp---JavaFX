package company.managers;

import company.employees.AbstractEmployee;
import company.employees.Employee;

public interface Manager extends Employee {

    void hire(AbstractEmployee employee);

    void fire(AbstractEmployee employee);

    boolean canHire(AbstractEmployee employee);

}

