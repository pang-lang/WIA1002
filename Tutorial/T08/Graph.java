package t9;

import java.util.LinkedList;

public class Graph {
    
    class Node {
        char data;
        LinkedList<Node> neighbours;

        public Node(char data) {
            this.data = data;
            this.neighbours = new LinkedList<>();
        }
    }

    LinkedList<Node> nodes;
      
    Graph(){
        this.nodes = new LinkedList<>();
    }
        
    public void addNode(char e){
        Node newNode = new Node(e);
        nodes.add(newNode);
    }
        
    public void addEdge(char src, char dest){
        Node srcNode = findNode(src);
        Node destNode = findNode(dest);
        if (srcNode != null && destNode != null){
            srcNode.neighbours.add(destNode);
            destNode.neighbours.add(srcNode); // For undirected graph
        }
    }
        
    public Node findNode(char data){
        for (Node n : nodes){
            if (n.data == data){
                return n;
            }
        }
        return null;
    }
        
    public void printGraph(){
        for (Node n : nodes){
            System.out.print("Adjacency list of vertex " + n.data + ": ");
            int count = 0;
            for (Node neighbour : n.neighbours) {
                System.out.print(neighbour.data);
                count++;
                if (count <= n.neighbours.size()-1) 
                    System.out.print(" -> ");        
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        for (char ch = 'A'; ch <= 'I'; ch++)
            graph.addNode(ch);
        
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.printGraph();
    }
}
