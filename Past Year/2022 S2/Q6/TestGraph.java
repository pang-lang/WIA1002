/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author panglang
 */
public class TestGraph {
    public static void main(String[] args) {
        int numVertices = 7;
        RoutingGraph myCityGraph = new RoutingGraph();
     
        // Adding vertices
        String[] pointNames = {"A", "B", "C", "D", "E", "F", "G"};
        for (String name : pointNames) {
            myCityGraph.addVertex(new Vertex(name));
        }
        
        myCityGraph.addEdge("A", "C", 1.0, 10.1); 
        myCityGraph.addEdge("A", "B", 1.0, 7.0); 
        myCityGraph.addEdge("B", "E", 1.25, 3.2); 
        myCityGraph.addEdge("B", "C", 1.0, 5.5); 
        myCityGraph.addEdge("C", "D", 1.25, 8.3); 
        myCityGraph.addEdge("D", "G", 1.5, 4.9); 
        myCityGraph.addEdge("E", "F", 1.5, 4.0); 
        myCityGraph.addEdge("E", "G", 1.5, 6.0); 
        myCityGraph.addEdge("E", "D", 1.25, 2.9); 
        myCityGraph.getSize();
        
        // Display information
        System.out.println("The number of vertices in MyCityGraph: " + myCityGraph.getSize());

        System.out.println("List all vertices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": " + myCityGraph.getVertex(i) + "     ");
        }

        System.out.println("\nHas edge from B to A? " + myCityGraph.hasEdge("B", "A"));
        System.out.println("Has edge from A to D? " + myCityGraph.hasEdge("A", "D"));

        System.out.println("\nFind all neighbours of B: " + myCityGraph.getNeighbours("B"));

        System.out.println("\nPrint all edges:");
        myCityGraph.printEdges();
        
        
        
    }
    
}
