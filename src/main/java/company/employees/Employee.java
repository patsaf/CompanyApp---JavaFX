package company.employees;

import company.employees.details.*;
import company.reports.Report;
import company.tasks.Task;
import company.tasks.TaskList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Employee {

    EmployeeType getType();

    EmployeeRole getRole();
    
    int getUnitsOfWork();

    FirstName getFirstName();

    LastName getLastName();

    Email getEmail();

    Gender getGender();

    Country getCountry();

    University getUniversity();

    TaskList getTaskList();

    void assign(Task task, Employee employee);

    Report reportWork();
}
