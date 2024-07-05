package Q1;


public class Graph<T extends Comparable<T>> {
    
    class Edge<T extends Comparable<T>> {
        Vertex<T> toVertex;
        Edge<T> nextEdge;

        public Edge(Vertex<T> destination, Edge<T> a) {
            toVertex = destination;
            nextEdge = a;
        }
    }

    class Vertex<T extends Comparable<T>> {
        T vertexInfo;
        int indeg;
        int outdeg;
        Vertex<T> nextVertex;
        Edge <T> firstEdge;

        public Vertex() {
            vertexInfo = null;
            indeg = 0;
            outdeg = 0;
            nextVertex = null;
            firstEdge = null;
        }

        public Vertex(T vInfo, Vertex<T> next) {
            vertexInfo = vInfo;
            indeg = 0;
            outdeg = 0;
            nextVertex = next;
            firstEdge = null;
        }
    }
    
    

    Vertex<T> head;
    int size;

    public Graph() {
        head = null;
        size = 0;
    }

    public boolean addVertex(T v) {
        if (!hasVertex(v)) {
            Vertex<T> newVertex = new Vertex<>(v, head);
            head = newVertex;
            size++;
            return true;
        }
        return false;
    }

    public boolean hasVertex(T v) {
        Vertex<T> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0)
                return true;
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addEdge(T source, T destination) {
        if (head == null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination))
            return false;

        Vertex<T> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Vertex<T> destinationVertex = head;
                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        Edge<T> currentEdge = sourceVertex.firstEdge;
                        Edge<T> newEdge = new Edge<>(destinationVertex, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination) {
        return addEdge(source, destination) && addEdge(destination, source);
    }
    
    
    public boolean removeEdge(T source, T destination) {
        if (head == null)
            return false;
        if (!hasVertex(source) || !hasVertex(destination)) 
            return false;

        Vertex<T> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Edge<T> currentEdge = sourceVertex.firstEdge;
                Edge<T> prevEdge = null;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        if (prevEdge == null) {
                            // Edge is the first edge of the source vertex
                            sourceVertex.firstEdge = currentEdge.nextEdge;
                        } else {
                            // Edge is not the first edge of the source vertex
                            prevEdge.nextEdge = currentEdge.nextEdge;
                        }
                        sourceVertex.outdeg--;
                        currentEdge.toVertex.indeg--;
                        return true;
                    }
                    prevEdge = currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
                return false; // Destination vertex not found among edges of source
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false; // Source vertex not found
    }

    public void printGraph() {
        Vertex<T> temp = head;
        while (temp != null) {
            System.out.print("Vertex " + temp.vertexInfo + " (Outdegree: " + temp.outdeg + ", Indegree: " + temp.indeg + "): ");
            Edge<T> edge = temp.firstEdge;
            while (edge != null) {
                System.out.print(edge.toVertex.vertexInfo + " ");
                edge = edge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }
    
    
/*
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        System.out.println("Graph before removing edge:");
        graph.printGraph();

        System.out.println("\nRemoving edge between A and B...");
        graph.removeEdge("A", "B");
        graph.removeEdge("D", "E");

        System.out.println("\nGraph after removing edge:");
        graph.printGraph();
    }
}
*/
}
