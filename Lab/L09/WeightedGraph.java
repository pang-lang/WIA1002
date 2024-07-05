/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

import java.util.ArrayList;

public class WeightedGraph <T extends Comparable<T>, N extends Comparable <N>> {
    class Edge <T extends Comparable<T>, N extends Comparable <N>> {
	Vertex<T,N> toVertex;
	N weight;
	Edge<T,N> nextEdge;
	
	public Edge()	{
		toVertex = null;
		weight = null;
		nextEdge = null;
	}
	
	public Edge(Vertex<T,N> destination, N w, Edge<T,N> a)	{
		toVertex = destination;
		weight = w;
		nextEdge = a;
	}
    }


    class Vertex<T extends Comparable<T>, N extends Comparable <N>> {
        T vertexInfo;
        int indeg;
        int outdeg;
        Vertex<T,N> nextVertex;
        Edge <T,N> firstEdge;
    
        public Vertex() {
            vertexInfo=null;
            indeg=0;
            outdeg=0;
            nextVertex = null;
            firstEdge = null;
        }
	
        public Vertex(T vInfo, Vertex<T,N> next) {
            vertexInfo = vInfo;
            indeg=0;
            outdeg=0;
            nextVertex = next;
            firstEdge = null;
        }
    }

        Vertex<T,N> head;
        int size;
	
        public WeightedGraph(){
            head=null;
            size=0;
        }
   
        public void clear() {   
            head=null;
        }

        public int getSize()   {
            return this.size;
        }
   
        public int getIndeg(T v)  {
            if (hasVertex(v)==true)	{
                Vertex<T,N> temp = head;
                while (temp!=null) {
                    if ( temp.vertexInfo.compareTo( v ) == 0 )
                        return temp.indeg;
                    temp=temp.nextVertex;
                }
            }
            return -1;
        }
         
        public int getOutdeg(T v)  {
            if (hasVertex(v)==true)	{
            Vertex<T,N> temp = head;
            while (temp!=null) {
                if ( temp.vertexInfo.compareTo( v ) == 0 )
                return temp.outdeg;
                temp=temp.nextVertex;
            }
        }
        return -1;
        }

        public boolean hasVertex(T v){
            if (head==null)
                return false;
            Vertex<T,N> temp = head;
            while (temp!=null){
                if ( temp.vertexInfo.compareTo( v ) == 0 )
                    return true;
                temp=temp.nextVertex;
            }
            return false;
        }

        public int getIndex(T v) {
            Vertex<T,N> temp = head;
            int pos=0;
            while (temp!=null){
                if ( temp.vertexInfo.compareTo( v ) == 0 )
                    return pos;
                temp=temp.nextVertex;
                pos+=1;
            }
            return -1;
        }
   
        public ArrayList<T> getAllVertexObjects() {
            ArrayList<T> list = new ArrayList<>();
            Vertex<T,N> temp = head;
            while (temp!=null)	{
                list.add(temp.vertexInfo);
                temp=temp.nextVertex;
            }
            return list;
        }

        public boolean addVertex(T v){
            if (hasVertex(v)==false){
                Vertex<T,N> temp=head;
                Vertex<T,N> newVertex = new Vertex<>(v, null);
            if (head==null)   
                head=newVertex;
            else {
                Vertex<T,N> previous=head;;
                while (temp!=null)  {
                    previous=temp;
                    temp=temp.nextVertex;
                }
                previous.nextVertex=newVertex;
            }
            size++;
            return true;
            }
            else
                return false;
        }
   

        public T getVertex(int pos) {
            if (pos>size-1 || pos<0) 
                return null;
            Vertex<T,N> temp = head;
            for (int i=0; i<pos; i++)
                temp=temp.nextVertex;
            return temp.vertexInfo;
        }
        
        public boolean hasEdge(T source, T destination) {
            if (head==null)
                return false;
            if (!hasVertex(source) || !hasVertex(destination)) 
                return false;
            Vertex<T,N> sourceVertex = head;
            while (sourceVertex!=null)	{
                if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                // Reached source vertex, look for destination now 
                    Edge<T,N> currentEdge = sourceVertex.firstEdge;
                    while (currentEdge != null) {
                        if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0) 
                        // destination vertex found 
                        return true;
                        currentEdge=currentEdge.nextEdge;
                    }
                    //return false;
                }
                sourceVertex=sourceVertex.nextVertex;
            }
            return false;
        }

        public N getEdgeWeight(T source, T destination) {
            N notFound=null;
            if (head==null)
                return notFound;
            if (!hasVertex(source) || !hasVertex(destination)) 
                return notFound;
            Vertex<T,N> sourceVertex = head;
            while (sourceVertex!=null)	{
                if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                    // Reached source vertex, look for destination now 
                    Edge<T,N> currentEdge = sourceVertex.firstEdge;
                    while (currentEdge != null) {
                        if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0) 
                        // destination vertex found 
                        return currentEdge.weight;
                        currentEdge=currentEdge.nextEdge;
                    }
                }
                sourceVertex=sourceVertex.nextVertex;
            }
            return notFound;
        }
        
        public ArrayList<T> getNeighbours (T v)  {
            if (!hasVertex(v))
                return null;
            ArrayList<T> list = new ArrayList<T>();
            Vertex<T,N> temp = head;
            while (temp!=null)	{
                if ( temp.vertexInfo.compareTo( v ) == 0 )   {
                    // Reached vertex, look for destination now
                    Edge<T,N> currentEdge = temp.firstEdge;
                    while (currentEdge != null) {
                        list.add(currentEdge.toVertex.vertexInfo);
                        currentEdge=currentEdge.nextEdge;
                    }
                }
                temp=temp.nextVertex;
            }
            return list;   
        }
        
        
        public boolean addEdge(T source, T destination, N w) {
            if (head==null)
                return false;
            if (!hasVertex(source) || !hasVertex(destination)) 
                return false;
            
            Vertex <T,N> sourceVertex = head;
            while (sourceVertex != null) {
                if ( sourceVertex.vertexInfo.compareTo( source ) == 0 ) {
                // Reached source vertex, look for destination now
                    Vertex <T,N> destinationVertex = head;
                    while (destinationVertex != null) {
                        if ( destinationVertex.vertexInfo.compareTo(destination ) == 0 ){
                            // Reached destination vertex, add edge here
                            Edge<T,N> currentEdge = sourceVertex.firstEdge;
                            Edge<T,N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                            sourceVertex.firstEdge=newEdge;
                            sourceVertex.outdeg++;
                            destinationVertex.indeg++;
                            return true;
                        }
                        destinationVertex=destinationVertex.nextVertex;
                    }
                }
            sourceVertex=sourceVertex.nextVertex;
            }
            return false;
        }
        
        //1
        public boolean addUndirectedEdge(T source, T destination, N w){
            if (head == null)
                return false;
            if (!hasVertex(source) || !hasVertex(destination)) 
                return false;
            
            Vertex <T,N> sourceVertex = head;
            while (sourceVertex != null){
                if (sourceVertex.vertexInfo.compareTo( source ) == 0 ){
                // Reached source vertex, look for destination now
                    Vertex <T,N> destinationVertex = head;
                    while (destinationVertex != null)	{
                        if ( destinationVertex.vertexInfo.compareTo(destination ) == 0 )   {
                        // Reached destination vertex, add edge here
                            Edge<T,N> currentEdge = sourceVertex.firstEdge;
                            Edge<T,N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                            sourceVertex.firstEdge = newEdge;
                            sourceVertex.outdeg++;
                            destinationVertex.indeg++;
                            
                            currentEdge = destinationVertex.firstEdge;
                            newEdge = new Edge <>(sourceVertex, w, currentEdge);
                            destinationVertex.firstEdge = newEdge;
                            sourceVertex.outdeg++;
                            destinationVertex.indeg++;
                            return true;
                        }
                        destinationVertex=destinationVertex.nextVertex;
                    }
                }
                sourceVertex=sourceVertex.nextVertex;
            }
            return false;
        }
        
        //2
        public boolean removeEdge(T source, T destination) {
            if (head == null)
                return false;
            if (!hasVertex(source) || !hasVertex(destination)) 
                return false;

            Vertex<T, N> sourceVertex = head;
            while (sourceVertex != null) {
                if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                    Edge<T, N> currentEdge = sourceVertex.firstEdge;
                    Edge<T, N> prevEdge = null;
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
            Vertex <T, N> temp = head;
            while (temp != null) {
                System.out.print("Vertex " + temp.vertexInfo + " (Outdegree: " + temp.outdeg + ", Indegree: " + temp.indeg + "): ");
                Edge <T, N> edge = temp.firstEdge;
                while (edge != null) {
                    System.out.print("(" + edge.toVertex.vertexInfo + ", " + edge.weight + ") ");
                    edge = edge.nextEdge;
                }
                System.out.println();
                temp = temp.nextVertex;
            }
        }
        
        public static void main(String[] args) {
            WeightedGraph<String, Integer> graph = new WeightedGraph<>();
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addVertex("D");
            graph.addVertex("E");

            graph.addEdge("A", "B", 1);
            graph.addEdge("B", "C", 2);
            graph.addEdge("C", "D", 5);
            graph.addEdge("D", "E", 3);           

            System.out.println("Graph before removing edge:");
            graph.printGraph();

            System.out.println("\nRemoving edge between A and B...");
            graph.removeEdge("A", "B");
            graph.removeEdge("D", "E");

            System.out.println("\nGraph after removing edge:");
            graph.printGraph();
        }
}


