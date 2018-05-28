
Sorting In Place: Yes
Stable: Yes

METHOD1: Inefficient as it always takes O(n^2) time complexity.But if array is sorted we can bring it to O(n) time complexity.

public class bubble_sort {
    public static void main(String[] args) {
        int arr[]={9,0,12,-1,3,6,7,3};
       for(int i=0;i<arr.length-1;i++)
       {
           
           for(int j=i;j<arr.length-i-1;j++)
           {
               if(arr[j]>arr[j+1])
               {
                   int temp=arr[j+1];
                   arr[j+1]=arr[j];
                   arr[j]=temp;
               }
           }
       }
        for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]+"  ");
    }
   }


METHOD2: Efficient-> 

public class bubble_sort {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
       for(int i=0;i<arr.length-1;i++)
       {
           boolean swapped=true;           
           for(int j=i;j<arr.length-i-1;j++)
           {
               if(arr[j]>arr[j+1])
               {
                   int temp=arr[j+1];
                   arr[j+1]=arr[j];
                   arr[j]=temp;
                   swapped=false;
               }
           }
           if(swapped==true)
                break;
        }
        for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]+"  ");
    }
    }
  }
  
 NOTE: best case of bubble sort is O(n) while worst case and average case O(n^2)[this occurs when array is reverse sorted]
