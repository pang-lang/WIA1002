/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m;

import java.util.ArrayList;
import java.util.List;


public class Task implements Comparable<Task> {
    private String taskName;
    private int estimatedRunTime;
    private List<String> dependencies = new ArrayList<>();

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getEstimatedRunTime() {
        return estimatedRunTime;
    }

    public void setEstimatedRunTime(int estimatedRunTime) {
        this.estimatedRunTime = estimatedRunTime;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }


    public Task(String name, int runTime) {
        taskName = name;
        estimatedRunTime = runTime;
    }

    public void addDependency(String dependency) {
        dependencies.add(dependency);
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(estimatedRunTime, o.estimatedRunTime);
    }

    @Override
    public String toString() {
        return "Task " + taskName + " : " + estimatedRunTime;
    }


}
