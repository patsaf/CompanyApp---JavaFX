package company.employees;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
public class EmployeeList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<AbstractEmployee> list;

    public EmployeeList() {
        list = new ArrayList<>();
    }

    public int getSize() { return list.size(); }

    public void sort() {
        Collections.sort(list, Comparator.comparingInt(Employee::getUnitsOfWork));
    }

    public Employee getEmployee(int i) { return list.get(i); }

    public void addEmployee(AbstractEmployee employee) {
        list.add(employee);
    }

    public void removeEmployee(Employee employee) { list.remove(employee); }

    @Override
    public String toString() {
        String output = "\n";
        for(Employee e: list) {
            output += e;
        }
        return output + "\n";
    }
}
