/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author panglang
 */

public class RoutingGraph {
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;

    public RoutingGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex point) {
        vertices.add(point);
    }

    public void addEdge(String start, String end, double speed, double distance) {
        edges.add(new Edge(start, end, speed, distance));
        edges.add(new Edge(end, start, speed, distance));
    }

    public int getSize() {
        return vertices.size();
    }

    public String getVertex(int index) {
        if (index >= 0 && index < vertices.size()) {
            return vertices.get(index).name;
        }
        return null;
    }

    public boolean hasEdge(String start, String end) {
        for (Edge edge : edges) {
            if (edge.start.equals(start) && edge.end.equals(end)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getNeighbours(String vertex) {
        ArrayList<String> neighbours = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.start.equals(vertex)) {
                neighbours.add(edge.end);
            }
        }
        return neighbours;
    }

    public void possiblePath(String src, String dest){
        Stack <String> stack = new Stack<>();
        ArrayList <String> path = new ArrayList<>();
        stack.push(src);
        
        while (!stack.isEmpty()){
            String vertex = stack.peek();
            if (vertex.equals(dest)){
                path.add(vertex);
                System.out.println("Possible path from " + src + " to " + dest + ": " + path);
                return;
            }

            boolean found = false;
            for (Edge edge : edges) {
                if (edge.start.equals(vertex) && !path.contains(edge.end)) {
                    stack.push(edge.end);
                    path.add(vertex);
                    found = true;
                    break;
                }
            }

            if (!found) {
                path.remove(vertex);
                stack.pop();
            }
        }

        System.out.println("No path found from " + src + " to " + dest);
    }
    
    public void printEdges() {
        for (Vertex vertex : vertices) {
            System.out.print("# " + vertex.name + " ");
            for (Edge edge : edges) {
                if (edge.start.equals(vertex.name)) {
                    System.out.print("[" + edge.start + "," + edge.end + "(speed=" + edge.speed + " , distance=" + edge.distance + ")] ");
                }
            }
            System.out.println();
        }
    }
}
