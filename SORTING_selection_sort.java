

public class selection_sort {
    public static void main(String[] args) {
        int arr[]={9,0,12,-1,3,6,7,3};
       for(int i=0;i<arr.length;i++)
       {
           for(int j=i+1;j<arr.length;j++)
           {
               if(arr[j]<arr[i])
               {
                   int temp=arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
               }
           }
       }
    for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]+"  ");
    }
   }
}

/*
run:
-1  0  3  3  6  7  9  12  BUILD SUCCESSFUL (total time: 0 seconds)
*/

/*
Time Complexity: O(n2) as there are two nested loops.

Auxiliary Space: O(1)
The good thing about selection sort is it never makes more than O(n) swaps and 
can be useful when memory write is a costly operation.

*/

