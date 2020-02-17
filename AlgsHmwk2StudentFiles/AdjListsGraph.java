// AdjListsGraph.java
//
// Implementation of an adjacency lists representation of a graph
//
public class AdjListsGraph {
    private ENode[] adjList;  // Entry adjList[i] either stores null or a reference to an ENode object,                               
    // which is the first node in vertex i's list of outgoing edges.
    private int numVertices;  // number of vertices

    public class ENode {
        private int dest;   // edge's destination vertex 
        private ENode next; // link to next node in adjacency list
        // constructor
        public ENode( int d, ENode n ) { dest = d; next = n; }
    }
    
    // Constructs a graph of V vertices and 0 edges. 
    // @param v number of vertices in the graph
    public AdjListsGraph( int v ) {
        adjList = new ENode[v]; // this array is automatically initialized to nulls 
        numVertices = v;
    }

    /**
     *  Adds a directed edge from vertex s to vertex d
     *  @param s source vertex of edge
     *  @param d destination vertex of edge
     */
    private void addDirectedEdge( int s, int d ) {
        // if parameters are invalid, just return
        if ( (s < 0) || (d < 0) || (s >= numVertices) || (d >= numVertices)) {
            System.out.println( "Invalid parameter to addEdge" );
            return;
        }

        // insert a new ENode at the beginning of the list
        adjList[s] = new ENode(d,adjList[s]);
    }

    /**
     *  Adds an udirected edge between vertex v1 and v2
     *  @param v1 one vertex of the edge
     *  @param v2 the other vertex of the edge
     */
    public void addEdge( int v1, int v2 ) {
        addDirectedEdge( v1, v2 );
        addDirectedEdge( v2, v1 );
    }

    /**
     *  Returns the number of (undirected) edges in the graph
     *  @return number of (undirected) edges in the graph 
     */
    public int numEdges() {
        
        int totaldegree = 0;
        
        for ( int i=0; i < adjList.length;i++){
          
            if(adjList[i] !=null){
          //totaldegree += degree(this.adjList[i].dest) ;
          
          
          ENode n1 = this.adjList[i];
          
       while (n1 != null){
           
           totaldegree++;
           n1=n1.next;
           
        
        }
        }
        
        }
        
        
        //System.out.println("Total: "+totaldegree );
        return totaldegree/2 ;
    }
    
    /**
     *  Returns the number of (undirected) edges adjacent to 
     *  vertex v.  If v is not a valid vertex number, returns -1.
     *  @return number of (undirected) edges adjacent to vertex v 
     */
    
    
    
    public int degree( int v ) {
        int counter=0;
        
        ENode n1 =this.adjList[v];
          
       while (n1 != null){
           
           counter++;
           n1=n1.next;
           
        
        }
        
        
        return counter;
          
            }
        
       
    /**
     *  This method determines if the graph contains an Euler circuit. 
     *  You may assume that the graph calling the method is a connected graph.
     *  @return true if the graph contains an Euler circuit, and false otherwise
     */
    public boolean hasEulerCircuit() {
        
        
        
        //int totaldegree = 0;
        int evenDegrees = 0;
        
        //LOOPING THROUGH THE VERTICES
        for ( int i=0; i < adjList.length;i++){
          
            // CHECKING IF THE VERTEX IS CONNECTED TO OTHER NODES
            if(adjList[i] !=null){
          //totaldegree += degree(this.adjList[i].dest) ;
            int degrees = 0;
          
          ENode n1 = this.adjList[i];
       //LOOPING THE ADJLIST OF THE NODE WHICH IS CONNECTED TO OTHERS   
       while (n1 != null){
           
           //totaldegree++;
           n1=n1.next;
           degrees +=1;
        
        }
        // TO CHECK IF THE DEGREE IS EVEN AS EULERCIRCUIT IS DEFINED
          if(degrees % 2 == 0){
               evenDegrees++;
            }
        
        }
        
        }
        
        //DEBUGGING PURPOSE
        //System.out.println("Total: "+totaldegree );
        //return totaldegree/2 ;
        
        
        //RETURN TRUE IF EVEN NUMBER OF DEGREES EQUAL TO NUMBER OF VERTICES
       return evenDegrees == numVertices; 
    }
    
    /**
     *  A ring graph is an undirected graph in which the edges connect the vertices 
     *  into a single cycle, or a ring. In such a graph, each vertex has degree two, 
     *  and the total number of (undirected) edges is |V|.
     *  This method returns true if the graph is a ring graph, and false otherwise.
     *  @return true if the graph is a ring graph, and false otherwise
     */
    public boolean isRingGraph() {
        //COUNTER OF NODE OF 2 DEGREES
        int twoDegrees = 0;
        
        //LOOPING THROUGH EACH NODE
        for ( int i=0; i < adjList.length;i++){
          
            if(adjList[i] !=null){
          //totaldegree += degree(this.adjList[i].dest) ;
            int degrees = 0;
          
          ENode n1 = this.adjList[i];
         //LOOPING THE CONNECTED NODES 
       while (n1 != null){
           
           //totaldegree++;
           n1=n1.next;
           degrees +=1;
        
        }
        //CHECKING IF TWO DEGREES
          if(degrees == 2){
               twoDegrees++;
            }
        
        }
        
        }
        
        
        //System.out.println("Total: "+totaldegree );
        //return totaldegree/2 ;
        // TOTAL EDGES
         int edges = numEdges();
         
        // ACCORDING TO THE DEFINITION OF RING OF GRAPH
        // TWODEGREES EQUAL TO NUM OF VERTICES AND EDGES EQUAL NUMBER OF VERTICES AND ATLEAST 3 OR ABOVE VERTICES
       return ((twoDegrees == numVertices) && (edges == numVertices) && (numVertices >=3)) ; 
        
        
        
    }

}
