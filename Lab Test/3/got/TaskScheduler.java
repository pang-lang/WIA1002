/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cgpt;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskScheduler {
    Map<String, Task> tasks;

    public TaskScheduler() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task t) {
        tasks.put(t.taskname, t);
    }

    public void addDependencies(String parent, String child) {
        if (tasks.containsKey(parent) && tasks.containsKey(child)) {
            tasks.get(child).addDependency(parent);
        }
    }

    public void readTask(String f) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] l = line.split(" ");
                String taskname = l[1].trim();
                String filename = l[2].replace(".sub", ".txt").trim();
                int runtime = readSubFile(filename);
                Task task = new Task(taskname, runtime);
                addTask(task);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Input file got error");
        }
    }

    public void readDependencies(String f) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] l = line.split(" ");
                String parent = l[1].trim();
                for (int i = 3; i < l.length; i++) {
                    String child = l[i].trim();
                    addDependencies(parent, child);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Input file got error");
        }
    }

    public int readSubFile(String f) {
        int runtime = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] l = line.split(" ");
                runtime = Integer.parseInt(l[2].trim());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Input file got error");
        }
        return runtime;
    }

    public void topologicalSort(Task task, Stack<Task> stack, Set<String> visited) {
        visited.add(task.taskname);

        for (String dep : task.dependencies) {
            if (!visited.contains(dep)) {
                topologicalSort(tasks.get(dep), stack, visited);
            }
        }
        stack.push(task);
    }

    public void getSortedTask() {
        List<Task> sortedTask = new ArrayList<>(tasks.values());
        Comparator<Task> comparator = new Comparator<>() {
            public int compare(Task o1, Task o2) {
                return Integer.compare(o1.getRuntime(), o2.getRuntime());
            }
        };
        sortedTask.sort(comparator);
        for (Task task : sortedTask) {
            System.out.println("Task " + task.taskname + " : " + task.runtime);
        }
    }

    public void findCriticalPath() {
        Set<String> visited = new HashSet<>();
        Stack<Task> stack = new Stack<>();
        for (Task task : tasks.values()) {
            if (!visited.contains(task.taskname))
                topologicalSort(task, stack, visited);
        }

        Map<String, Integer> dist = new HashMap<>();
        for (Task task : tasks.values()) {
            dist.put(task.taskname, Integer.MIN_VALUE);
        }

        // Set the distance of the starting node to 0
        if (!stack.isEmpty()) {
            dist.put(stack.peek().taskname, 0);
        }

        while (!stack.isEmpty()) {
            Task task = stack.pop();
            if (dist.get(task.taskname) != Integer.MIN_VALUE) {
                for (String dep : task.dependencies) {
                    int newDist = dist.get(task.taskname) + task.runtime;
                    if (dist.get(dep) < newDist) {
                        dist.put(dep, newDist);
                    }
                }
            }
        }

        int maxDist = Collections.max(dist.values());
        List<String> criticalPath = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dist.entrySet()) {
            if (entry.getValue() == maxDist) {
                criticalPath.add(entry.getKey());
            }
        }
        System.out.println("Critical path: " + String.join(" -> ", criticalPath));
        System.out.println("Total Run Time: " + maxDist);
    }
}