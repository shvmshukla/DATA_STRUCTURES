/*
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x 
is the first greater element on the right side of x in array.
Elements for which no greater element exist, consider next greater element as -1.

https://www.geeksforgeeks.org/next-greater-element/
*/

import java.util.Stack;
import java.util.Arrays;

public class next_greater_element_in_array {
     public static void main(String[] args) {
     int arr[]= {1,3,2,4,6,0};
  //  int arr[]= {1,2,3,-1,5,};
     Stack<Integer> s= new Stack<Integer>();
        s.push(arr[0]);
    
     for(int i=1;i<arr.length;i++)
     {
         int next=arr[i];
         int element= s.pop(); //1
      if(!s.isEmpty())
      {
         while(element < next)
         {
             System.out.println(element+"--->"+next);
              if(s.isEmpty())
              {
                  break;
              }
            element=s.pop();  
         }
        if(element>next)
        {
            s.push(element);
        }
      }     
        s.push(next);
     }
     //for remaining elements in stack print -1
     for(int i=0;i<s.size();i++)
     {
         System.out.println(s.pop()+"-->"+-1);
     }
    }
          
}

/*
OUTPUT
run:
1--->3
2--->4
3--->4
4--->6
0-->-1
BUILD SUCCESSFUL (total time: 0 seconds)

*/
