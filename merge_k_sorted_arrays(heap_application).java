/*
Given K sorted arrays arranged in a form of a matrix, your task is to merge them into a sorted list.

arr[][] = [[1, 2, 3],

             [4, 5, 6],

             [7, 8, 9]]
The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9]
*/

import java.util.*;
 class Node
{
     int element,index,pos;
 Node(int se,int i,int p)
 {
     this.element= element;
     this.index=index;
     this.pos=pos;
 }
}

public class merge_k_sorted_lists
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int k=sc.nextInt();
        int arr[][]= new int[k][k];
       for(int i=0;i<k;i++)
       {
           for(int j=0;j<k;j++)
           {
               arr[i][j]=sc.nextInt();
           }
           System.out.println("");
       }
        
       PriorityQueue<Node> pq= new PriorityQueue<Node>(new Comparator<Node>(){
             @Override
             public int compare(Node n1,Node n2)
             {
                 return n1.element-n2.element;
             }
       });
       
        ArrayList<Integer> al= new ArrayList<Integer>();
      
      for(int i=0;i<k;i++)
      {
          Node temp= new Node(arr[i][0],i,0);
           pq.add(temp);
      }
      
      while(!pq.isEmpty())
      {
          al.add(pq.peek().element);
          int r= pq.peek().index;
          int c= pq.peek().pos;
          if(c<k-1)
          {
              Node temp= new Node(arr[r][c+1],r,c+1);
              pq.add(temp);
          }
          
      }
        
        System.out.println(al);
    }
    
    
}
