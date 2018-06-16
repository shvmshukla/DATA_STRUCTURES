/*
https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0
Given an input stream of n integers the task is to insert integers to stream and print the kth largest element in the stream at each insertion.

Example:

Input:
stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
k = 3

Output:    {-1,   -1, 10, 11, 20, 40, 50,  50, ...}

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains two space separated integers k and n . Then in the next line are n space separated values of the array.

Output:
For each test case in a new line print the space separated values denoting the kth largest element at each insertion, if the kth largest element at a particular insertion in the stream doesn't exist print -1.

Constraints:
1<=T<=100
1<=n,k<=1000
1<=stream[]<=100000

Example:
Input:
2
4 6
1 2 3 4 5 6
1 2
3 4 

Output:
-1 -1 -1 1 2 3
3 4 
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class kth_largest_element_in_a_stream_of_integers {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
                int t=sc.nextInt();
while(t-->0)
 {       
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
       int min=Integer.MIN_VALUE;
      int k=sc.nextInt();
      int n=sc.nextInt();
      for(int i=1;i<=n;i++)
      {
       int temp = sc.nextInt();
       if(i<k)
       {   pq.add(temp);
           System.out.print("-1 ");
       }
       else
       {
          if(i==k)
          {
              pq.add(temp);
              min=pq.peek();
              System.out.print(min+" ");
          }
          else
          {
              if(temp>pq.peek())
              {
                  pq.poll();
                  pq.add(temp);
                  System.out.print(pq.peek()+" ");
                  min= pq.peek();
              }
              else
              {
                System.out.print(min+" ");  
              }
          }
          
           
       }
           
      
      }
    }
  }
}
