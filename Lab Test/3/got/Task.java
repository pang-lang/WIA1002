/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cgpt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panglang
 */
public class Task {
    protected String taskname;
    protected int runtime;
    protected List <String> dependencies;

    public Task(String taskname, int runtime) {
        this.taskname = taskname;
        this.runtime = runtime;
        this.dependencies = new ArrayList<>();
    }
    
    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
    
    public void addDependency(String taskname){
        dependencies.add(taskname);
    }
}
