/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element.
Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
*/


public class minimum_jumps_to_destination {
    public static void main(String[] args) {
        int arr[]={1,3,5,8,9,2,6,7,6,8,9};
      int jump[]= new int[arr.length];
      int result[]= new int[arr.length];
     jump[0]=0;
     for(int i=1;i<jump.length;i++)
        {
         jump[i]=Integer.MAX_VALUE;
        }
     for(int i=1;i<jump.length;i++)
     {
         for(int j=0;j<i;j++)
         {
             if(j+arr[j]>=i)
             {
                jump[i]=Math.min(jump[i],1+jump[j]) ;
                result[i]=j;
             }
     }
    }
     
     for(int i=0;i<arr.length;i++)
     {
         System.out.print(jump[i]+" ");
     }
        System.out.println("");
       
        System.out.println("Minimum steps to jump to destination are"+jump[jump.length-1]);
    
 }
}    

/*
OUTPUT:
run:
0 1 2 2 2 3 3 3 3 3 3 
Minimum steps to jump to destination are3
BUILD SUCCESSFUL (total time: 0 seconds)

*/
