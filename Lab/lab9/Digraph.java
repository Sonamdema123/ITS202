import java.util.NoSuchElementException;
import java.util.*;
import java.util.LinkedList;
public class Digraph {
    private final int V;                  // number of vertices in this digraph
    private int E;                        // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
                                            // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V) {
       this.V = V;
       this.E = 0;
       adj = new LinkedList[V];
       for (int v = 0;v < V; v++){
        adj[v] = new LinkedList<Integer>();
       } 
    }    
            
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int V() {
       return V;
    }
    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int E() {
       return E; 
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v<0 || v >= V) throw new IllegalArgumentException("Vertex should between"+v+"and"+(v-1));
    }
    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
   
    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    // public Digraph reverse() {
        
    // }
    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices and "+ E +" edges New path are:\n");
        for (int v = 0; v < V; v++){
            s.append(v + ":");
            for(int w : adj[v]){
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
      Digraph obj = new Digraph(6);
        obj.addEdge(2,1);
        obj.addEdge(1,5);
        obj.addEdge(1,2);
        obj.addEdge(4,3);

        System.out.println(obj.adj(4));
        System.out.println(obj.V());
        System.out.println(obj.E());
        System.out.println(obj.toString()); 
    }

}