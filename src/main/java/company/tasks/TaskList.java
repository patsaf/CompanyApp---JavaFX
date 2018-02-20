package company.tasks;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Task> listOfTasks;

    public TaskList() {
        listOfTasks = new ArrayList<>();
    }

    public void add(Task task) {
        listOfTasks.add(task);
    }

    public String toString() {
        String output = "All tasks completed: \n";
        for(Task t: listOfTasks) {
            output += "\t *" + t + "\n";
        }
        return output;
    }
}
