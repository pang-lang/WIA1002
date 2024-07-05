/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cgpt;

/**
 *
 * @author panglang
 */
public class Main {
    public static void main(String[] args) {
        TaskScheduler tasks = new TaskScheduler();
        tasks.readTask("tasks.txt");
        tasks.readDependencies("dependencies.txt");
        
        tasks.getSortedTask();
        tasks.findCriticalPath();
    }
    
}
