package company.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String taskName;
    private final int unitsOfWork;

    public Task() {
        taskName = null;
        unitsOfWork = 0;
    }

    public Task(String taskName, int unitsOfWork) {
        this.taskName = taskName;
        this.unitsOfWork = unitsOfWork;
    }

    public int getUnitsOfWork() { return unitsOfWork; }

    @Override
    public String toString() {
        return taskName + ", unitsOfWork = " + unitsOfWork;
    }
}
