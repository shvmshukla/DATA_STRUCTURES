/*
Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.

Time Complexity: O(n*n)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.

Algorithmic Paradigm: Incremental Approach

Sorting In Place: Yes

Stable: Yes

Online: Yes

Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

*/

public class insertion_sort {
    public static void main(String[] args) {
         int arr[]={9,0,12,-1,3,6,7,3};
        int j;
     for(int i=1;i<arr.length;i++)
     {
         int key=arr[i];
         for(j=i-1;j>=0 && arr[j]>key;j--)
         {
            arr[j+1]=arr[j];
            
         }
         arr[j+1]=key;
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
 

NOTE:
How to implement Insertion Sort for Linked List?
Below is simple insertion sort algorithm for linked list.

1) Create an empty sorted (or result) list
2) Traverse the given list, do following for every node.
......a) Insert current node in sorted way in sorted or result list.
3) Change head of given linked list to head of sorted (or result) list. 
*/
