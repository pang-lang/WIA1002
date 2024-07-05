/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Edge {
    Point to;
    Point from;
    double speed;
    double distance;

    public Edge(Point to, Point from, double speed, double distance) {
        this.to = to;
        this.from = from;
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "[" + from + "," + to + " (speed=" + speed + ", distance=" + distance + ")]";
    }
}

class Point {
    String name;

    public Point(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return name.equals(point.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

public class Graph {
    Map<Point, List<Edge>> adjList;

    public Graph() {
        this.adjList = new LinkedHashMap<>();
    }

    public void addVertex(Point src) {
        adjList.putIfAbsent(src, new ArrayList<>());
    }

    public void addEdge(Point src, Point dest, double speed, double distance) {
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(new Edge(dest, src, speed, distance));
        adjList.get(dest).add(new Edge(src, dest, speed, distance)); // Assuming bidirectional edges
    }

    public int getSize() {
        return adjList.keySet().size();
    }

    public void getVertex() {
        int index = 0;
        for (Point p : adjList.keySet()) {
            System.out.print(index + ": " + p.name + "   ");
            index++;
        }
    }

    public boolean hasEdge(Point src, Point dest) {
        List<Edge> edges = adjList.get(src);
        if (edges != null) {
            for (Edge e : edges) {
                if (e.to.equals(dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Point> getNeighbours(Point src) {
        List<Point> neighbours = new LinkedList<>();
        List<Edge> edges = adjList.get(src);
        if (edges != null) {
            for (Edge e : edges) {
                if (e.from.equals(src)) {
                    neighbours.add(e.to);
                }
            }
        }
        return neighbours;
    }

    public void printEdges() {
        for (Point p : adjList.keySet()) {
            System.out.print("# " + p + ": ");
            for (Edge edge : adjList.get(p)) {
                System.out.print(edge.toString() + " ");
            }
            System.out.println();
        }
    }
    
    public double calculateDistance(List<Point> p){
        double distance = 0;
        for (int i=0; i<p.size()-1; i++){
            Point src = p.get(i);
            Point dest = p.get(i+1);
            List <Edge> edges = adjList.get(src);
            if (edges != null){
                for (Edge e : edges){
                    if (e.to.equals(dest)){
                        distance += e.distance;
                        break;
                    }
                }
            }
        }
        return distance;
    }
    
    public double calculateDuration(List<Point> p){
        double duration = 0;
        for (int i=0; i<p.size()-1; i++){
            Point src = p.get(i);
            Point dest = p.get(i+1);
            List <Edge> edges = adjList.get(src);
            if (edges != null){
                for (Edge e : edges){
                    if (e.to.equals(dest)){
                        duration += e.distance / e.speed;
                        break;
                    }
                }
            }
        }
        return duration;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Point A = new Point("A");
        Point B = new Point("B");
        Point C = new Point("C");
        Point D = new Point("D");
        Point E = new Point("E");
        Point F = new Point("F");
        Point G = new Point("G");

        Point[] vertices = {A, B, C, D, E, F, G};

        for (Point vertex : vertices) {
            g.addVertex(vertex);
        }

        g.addEdge(A, B, 2.0, 7.0);
        g.addEdge(A, C, 1.0, 10.1);
        g.addEdge(B, C, 1.0, 5.5);
        g.addEdge(B, E, 1.25, 3.2);
        g.addEdge(C, D, 1.25, 8.3);
        g.addEdge(D, G, 1.5, 4.9);
        g.addEdge(E, D, 1.25, 2.9);
        g.addEdge(E, F, 1.5, 4.0);
        g.addEdge(E, G, 1.5, 6.0);
        g.addEdge(F, G, 1.2, 2.3);

        System.out.println("The number of vertices in myCityGraph: " + g.getSize());
        System.out.println("List all the vertices: ");
        g.getVertex();

        System.out.println("\nHas edge from B to A? " + g.hasEdge(B, A));
        System.out.println("Has edge from A to D? " + g.hasEdge(A, D));

        System.out.println("\nFind all neighbours of B : " + g.getNeighbours(B));
        System.out.println("\nPrint all edges: ");
        g.printEdges();
        
        List<Point> path1 = List.of(A, B, C, D, G);
        List<Point> path2 = List.of(A, B, E, G);
        List<Point> path3 = List.of(A, C, B, E, F, G);
        List<Point> path4 = List.of(A, B, E, D, G);
        List<Point> path5 = List.of(A, C, D, G);

        System.out.printf("Path 1: %s\nDistance= %.2f km, Duration= %.2f min\n", path1, g.calculateDistance(path1), g.calculateDuration(path1));
        System.out.printf("Path 2: %s\nDistance= %.2f km, Duration= %.2f min\n", path2, g.calculateDistance(path2), g.calculateDuration(path2));
        System.out.printf("Path 3: %s\nDistance= %.2f km, Duration= %.2f min\n", path3, g.calculateDistance(path3), g.calculateDuration(path3));
        System.out.printf("Path 4: %s\nDistance= %.2f km, Duration= %.2f min\n", path4, g.calculateDistance(path4), g.calculateDuration(path4));
        System.out.printf("Path 5: %s\nDistance= %.2f km, Duration= %.2f min\n", path5, g.calculateDistance(path5), g.calculateDuration(path5));
    }
}
