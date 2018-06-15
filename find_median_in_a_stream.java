/*
https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity 
assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …

After reading 1st element of stream - 5 -> median - 5
After reading 2nd element of stream - 5, 15 -> median - 10
After reading 3rd element of stream - 5, 15, 1 -> median - 5
After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class finding_median_in_a_stream {
    
    public static void addNum(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher, int num)
    {
        if(lower.size()==0 || num<lower.peek())
            lower.add(num);
        else
            higher.add(num);
    }
    
    public static void reBlnc(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
    {
        PriorityQueue<Integer> bigger = lower.size()>higher.size()?lower:higher;
        PriorityQueue<Integer> smaller = lower.size()>higher.size()?higher:lower;
        
        if(bigger.size()-smaller.size()>=2)
            smaller.add(bigger.poll());
    }
    
    public static int findMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
    {
        PriorityQueue<Integer> bigger = lower.size()>higher.size()?lower:higher;
        PriorityQueue<Integer> smaller = lower.size()>higher.size()?higher:lower;
        
        if(bigger.size()==smaller.size())
            return (bigger.peek()+smaller.peek())/2;
            
        else
            return bigger.peek();
    }
    
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer> () {
		    public int compare(Integer a, Integer b)
		    {
		        return b-a;
		    }
		    
		});
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		
		
		for(int i=0;i<n;i++)
		{
		    addNum(lower,higher,scan.nextInt());
		    reBlnc(lower,higher);
		    int median = findMedian(lower,higher);
		    System.out.println(median);
		}
	}
    
}
