
import java.util.Arrays;
public class radix_sort {
    public static void main(String[] args) {
       int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
       int m=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]>m)
               m=arr[i];
       }    
        int pass=1;
        for(int exp=1;m/exp>0;exp=exp*10)
        {
            System.out.println("after "+pass+" pass");
            
            counting_sort(arr,exp);
            pass++;
            System.out.println("");
        }
        System.out.println("sorted array is"); 
      for(int i=0;i<arr.length;i++)
       {
       System.out.print(arr[i]+" ");
       }
    }
    public static void counting_sort(int arr[],int exp)
    {
        int output[]= new int[arr.length];
    
    //Create a count array to store count of inidividual numbers and initialize count array as 0
    int count[]=new int[10];
    Arrays.fill(count,0);
    
    //store the count of each number in the input array    
   for(int i=0;i<arr.length;i++)
   {
       count[(arr[i]/exp)%10]++;
   }

//   Change count[i] so that count[i] now contains actual position of this character in output array
   for(int i=1;i<count.length;i++)
   {
       count[i]+=count[i-1];
   }
   
   //fill the output array   
   for(int i=arr.length-1;i>=0;i--)
    {
       output[count[((arr[i]/exp)%10)]-1]=arr[i];
       --count[((arr[i]/exp)%10)];
    }
  //Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit 
   for (int i = 0; i < arr.length; i++)
        arr[i] = output[i];

    
  for(int i=0;i<arr.length;i++)
   {
       System.out.print(arr[i]+" ");
   }
        System.out.println("");
  } 
}

/*
run:
after 1 pass
170 90 802 2 24 45 75 66 

after 2 pass
802 2 24 45 66 170 75 90 

after 3 pass
2 24 45 66 75 90 170 802 

sorted array is
2 24 45 66 75 90 170 802 BUILD SUCCESSFUL (total time: 0 seconds)
*/

/*
# What is the running time of Radix Sort?
Let there be d digits in input integers. Radix Sort takes O(d*(n+b)) time where b is the base for representing numbers, 
for example, for decimal system, b is 10. What is the value of d? If k is the maximum possible value, 
then d would be O(logb(k)). So overall time complexity is O((n+b) * logb(k)). Which looks more than the time complexity
of comparison based sorting algorithms for a large k. Let us first limit k. Let k <= nc where c is a constant. 
In that case, the complexity becomes O(nLogb(n)). But it still doesn’t beat comparison based sorting algorithms.
What if we make value of b larger?. What should be the value of b to make the time complexity linear? 
If we set b as n, we get the time complexity as O(n). In other words, we can sort an array of integers 
with range from 1 to nc if the numbers are represented in base n (or every digit takes log2(n) bits).

# Is Radix Sort preferable to Comparison based sorting algorithms like Quick-Sort?

If we have log2n bits for every digit, the running time of Radix appears to be better than Quick Sort for 
a wide range of input numbers. The constant factors hidden in asymptotic notation are higher for Radix Sort and Quick-Sort 
uses hardware caches more effectively. 
Also, Radix sort uses counting sort as a subroutine and counting sort takes extra space to sort numbers.


*/
