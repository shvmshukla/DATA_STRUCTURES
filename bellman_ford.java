
/**
 *
 * @author shivam
 */
import java.util.*;
public class bellman_ford {

     // A class to represent a weighted edge in graph
    class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    }
     Edge edge[];
    bellman_ford(int v,int e)
    {
        edge= new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    //it does the actual task in bellmanford algorithm 
    void bellman_ford(bellman_ford graph,int src)
    {
        int distance[]= new int[5];
        int parent[]  = new int[5];
      for(int i=0;i<5;i++)
      {
          distance[i]=Integer.MAX_VALUE;
          parent[i]= -1;
      }
          distance[0]=0;
          parent[0]= src;
       for(int j=1;j<5;j++)
       {
        for(int i=0;i<8;i++)
        {
            int u=graph.edge[i].src;
            int v=graph.edge[i].dest;
            int weight= graph.edge[i].weight;
           // System.out.println(u+"  "+v+"  "+weight);
          if(distance[u]!=Integer.MAX_VALUE && distance[v]>distance[u]+weight)
          {
              distance[v]=distance[u]+weight;
              parent[v]=u;
          }
        }
      
       }
           
      //check whether there is a negative cycle 
       for(int i=0;i<8;i++)
        {
            
            int u=edge[i].src;
            int v=edge[i].dest;
            int weight= edge[i].weight;
          if(distance[u]!=Integer.MAX_VALUE && distance[v]>distance[u]+weight)
          {
              //this means even after (V-1) iterations ,distance converges which implies there is a negative cycle in the graph 
              System.out.println("negative cycle is present in the graph");
          }
        }
      printArr(distance, 5); 
    }
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }
    
      
    //driver 
    public static void main(String[] args) {
      int V=5,E=8;  
      bellman_ford graph= new bellman_ford(V,E); 
      
      
        graph.edge[0].src = 3;
        graph.edge[0].dest = 4;
        graph.edge[0].weight = 2;
        
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 4;
        graph.edge[1].dest = 3;
        graph.edge[1].weight = 1;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 2;
        graph.edge[2].dest = 4;
        graph.edge[2].weight = 4;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 0;
        graph.edge[3].dest = 2;
        graph.edge[3].weight = 5;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = -3;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 0;
        graph.edge[5].dest = 3;
        graph.edge[5].weight = 8;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 0;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 4;
 
      graph.bellman_ford(graph,0);  
    
      
      // add edge 0-1 (or A-B in above figure)
     /*
      graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
    graph.bellman_ford(graph,0);  
    */
    }
}


//time complexity O(VE)  space complexity O(V)
