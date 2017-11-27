#include<stdio.h>
#include<stdlib.h>

struct node{
 int dest;
 int traverse_bit;
 struct node * next;

};

struct adj_list{
 struct node *head;
};

struct Graph{
 int V;
 struct adj_list *array;
};

struct node* createNode(int dest)
{
  struct node* temp= (struct node*) malloc(sizeof(struct node));
  temp->dest= dest;
  temp->next=NULL;
return temp;
}

int i;
struct Graph* create_Graph(int V)
{
  struct Graph *graph = (struct Graph*) malloc (sizeof (struct Graph));  //memorization of graph
  graph->V=V;
  graph->array= (struct adj_list*) malloc (V* sizeof(struct adj_list)); //memorization of array 

// initialize every list corresponding to vertex with null 
 for( i=0;i<graph->V;i++)
  {
    graph->array[i].head=NULL;
  }
return graph;
}


//add an edge 
 addEdge(struct Graph* graph,int src,int dest )
 {
//add an edge from source to destination
   struct node * newNode= createNode(dest);
   newNode->next=graph->array[src].head;
   graph->array[src].head= newNode;
   newNode->traverse_bit=0;
//since graph is undirected add an edge from destination to source
   newNode=createNode(src);
   newNode->next=graph->array[dest].head;
   graph->array[dest].head= newNode; 
   newNode->traverse_bit=0;
 }

//print graph
void printGraph(struct Graph* graph)
{
 for(i=0;i<graph->V;i++)
 {
   printf("\n Adjacency list of vertex %d\n head ", i);  
 struct node* temp= (struct node*) malloc(sizeof(struct node));
    temp= graph->array[i].head;
    while(temp!=NULL)
    {
     printf("%d->",temp->dest);
     temp=temp->next;
    }
  printf("\n");
 }
}
//stack.contains
int present(int x,int V,int visited[])
{
for(i=0;i<V;i++)
  {
  
    if(visited[i]==x)
    {
   //  printf("found %d   ",x);
     return 1;
     break;
    }
    
   }
 return 0; 
}

//DFS traversal o(VE)


void DFS_traversal(struct Graph * graph,int V,int src)
{
 static int visited[5];   
 static int i=0;
 int t; 
  visited[i++]=src;
  printf("%d -> ",src);
  //printf("\n");
 struct node *temp= graph->array[src].head;
 while(temp->next!=NULL)
  {
    if(!present(temp->dest,V,visited))
    {
      DFS_traversal(graph,V,temp->dest);
    }
    else 
      temp=temp->next;
   if(i==V)
    break;
   
  }
}

//DFS O(V+E)

void DFS_traversal_by_coloring(struct Graph * graph,int V,int src,int * visit)
{
 static int visited[5];   
 static int i=0;
 
  //visited[i++]=src;
  printf("%d -> ",src);
  //printf("\n");
  visit[src]=1;
 struct node *temp= graph->array[src].head;
 while(temp)
  {
   //printf("hello");
    if(visit[temp->dest]==0)
    {
     visit[temp->dest]=1;
      DFS_traversal_by_coloring(graph,V,temp->dest,visit);
    }
    //else
      temp=temp->next;
   //if(i==V)
   // break;
   
  }
}

//driver program
int main()
{
  int V=5;
int visit[5]={0};
  struct Graph *graph = create_Graph(V);   // create a graph containing 5 nodes
  addEdge(graph,0,1);
  addEdge(graph,0,4);
  addEdge(graph,1,2);
  addEdge(graph,1,3);
  addEdge(graph,1,4);
  addEdge(graph,2,3);
  addEdge(graph,3,4); 
 printGraph(graph); 
 printf("inefficient dfs");
 DFS_traversal(graph,V,0);
 printf("\nefficient dfs");
 DFS_traversal_by_coloring(graph,V,0,visit);
}
