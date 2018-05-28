/*
Counting sort is a sorting technique based on keys between a specific range. 
It works by counting the number of objects having distinct key values (kind of hashing). 
Then doing some arithmetic to calculate the position of each object in the output sequence.
*/

public class count_sort {
    public static void main(String[] args) {
        
    
    int arr[]={1,4,1,2,7,5,2};
    // The output int array that will have sorted arr
    int output[]= new int[arr.length];
    
    //Create a count array to store count of inidividual numbers and initialize count array as 0
    int count[]=new int[10];
    Arrays.fill(count,0);
    
//store the count of each number in the input array    
   for(int i=0;i<arr.length;i++)
   {
       count[arr[i]]++;
   }

//   Change count[i] so that count[i] now contains actual position of this character in output array
   for(int i=1;i<count.length;i++)
   {
       count[i]+=count[i-1];
   }
   
//fill the output array   
   for(int i=0;i<arr.length;i++)
    {
       output[count[arr[i]]-1]=arr[i];
       --count[arr[i]];
    }
   
   //print the sorted array stored in output[]
   for(int i=0;i<output.length;i++)
   {
       System.out.print(output[i]+" ");
   }
    
  }  
}

/*
run:
1 1 2 2 4 5 7 BUILD SUCCESSFUL (total time: 0 seconds)
*/

Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
Auxiliary Space: O(n+k)

Points to be noted:
1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
2. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
3. It is often used as a sub-routine to another sorting algorithm like radix sort.
4. Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
5. Counting sort can be extended to work for negative inputs also.

