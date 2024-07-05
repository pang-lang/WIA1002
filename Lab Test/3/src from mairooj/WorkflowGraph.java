/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class WorkflowGraph {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        // return a copy
        return new ArrayList(tasks);
    }

    public static void main(String[] args) {
        String file = "example.dag";
        WorkflowGraph graph = new WorkflowGraph();
        graph.constructGraph(file);

        System.out.println();
        System.out.println("Tasks sorted by estimated run time:");
        List<Task> sortedTasks = graph.getTasks();
        sortedTasks.sort(null);
        for (Task task: sortedTasks) {
            System.out.println(task);
        }

        
        System.out.println("\nCritical path:");
        List<Task> criticalPath = graph.getCriticalPath();
        StringBuilder str = new StringBuilder();
        for (int i=0; i<criticalPath.size(); i++){
            str.append("Task " + criticalPath.get(i).getTaskName());
            if (i != criticalPath.size()-1)
                str.append(" -> ");
        }
        System.out.println(str.toString());
        /*
        for (int i = 0; i < criticalPath.size(); i++) {
            System.out.print("Task " + criticalPath.get(i).getTaskName());
            if (i != criticalPath.size()-1) {
                System.out.print(" -> ");
            }
            else {
                System.out.println("");
            }
        }
        */
        
        int totalRuntime = 0;
        for (Task task: criticalPath) {
            totalRuntime += task.getEstimatedRunTime();
        }
        System.out.println("Total Run Time: " + totalRuntime);
    }

    public void constructGraph(String file) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                switch (parts[0]) {
                    case "JOB":
                        String taskName = parts[1];
                        int estimateRunTime = 0;
                        String subFileName = parts[2];
                        Scanner subReader = new Scanner(new FileInputStream(subFileName));
                        while (subReader.hasNextLine()) {
                            String[] lineParts = subReader.nextLine().split(" ");
                            switch (lineParts[0]) {
                                case "estimate_runtime":
                                    estimateRunTime = Integer.parseInt(lineParts[2]);
                                    break;
                            }
                        }
                        subReader.close();
                        Task newTask = new Task(taskName, estimateRunTime);
                        tasks.add(newTask);
                        break;

                    case "PARENT":
                        // find parents
                        ArrayList<String> parents = new ArrayList<>();
                        int i = 1;
                        for (; i < parts.length; i++) {
                            if (parts[i].equals("CHILD")) {
                                break;
                            } else {
                                parents.add(parts[i]);
                            }
                        }
                        // add dependencies for the parents
                        i += 1;
                        for (; i< parts.length; i++) {
                            for (String parent: parents) {
                                Task task = getTask(parent);
                                task.addDependency(parts[i]);
                            }
                        }
                        break;
                }
            }
            scanner.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public Task getTask(String name) {
        for (Task task: tasks) {
            if (task.getTaskName().equals(name)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getCriticalPath() {
        List<Task> criticalPath = new ArrayList<>();
        // start with the first node (task) as root
        Queue<Task> queue = new LinkedList<>();
        queue.offer(tasks.get(0));
        criticalPath.add(tasks.get(0));

        for (;;) {
            Task currentTask = queue.poll();
            
            // find the child task with the longest runtime
            int longestRuntime = 0;
            Task longestRuntimeTask = null;
            
            for (String dependency: currentTask.getDependencies()) {
                Task dep = getTask(dependency);
                if (dep.getEstimatedRunTime() > longestRuntime) {
                    longestRuntime = dep.getEstimatedRunTime();
                    longestRuntimeTask = dep;
                }
            }
            // did not find any child
            if (longestRuntimeTask == null) {
                break;
            }
            // add the longestRuntimeTask to the queue to search in next level of children
            queue.offer(longestRuntimeTask);
            // add the longestRuntimeTask to the critical path
            criticalPath.add(longestRuntimeTask);
        }
        return criticalPath;
    }
}
