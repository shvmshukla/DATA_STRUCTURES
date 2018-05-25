/*
https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
*/
/**
 *
 * @author shivam
 */
//Time complexity O(n^2).. but space complexity is O(1)(thats efficient) :p
import java.util.Stack;
public class sort_a_stack__using_recursion_inplace_sorting {
    static Stack<Integer> s= new Stack<Integer>();
    
    static void sorted_insert(int a)
    {
      if(s.isEmpty() || a>s.peek())
       {
        s.push(a);
        return;
       }
      
          int temp=s.peek();
          s.pop();
          sorted_insert(a);
          s.push(temp);
      }
    
    
    static void sort()
    {
        if(s.isEmpty()!=true)
        {
          int a=s.peek();
          s.pop();
          sort();
          sorted_insert(a);
        }
        
    }
    
    //driver
    public static void main(String[] args) {
        
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        
        System.out.println("before sorting stack is as follows");
        System.out.println(s);
          sort();
        System.out.println("before sorting stack is as follows");
        System.out.println(s);
        
    }
}

/*
run:
original stack is as follows
[1, 2, 3, 4]
After reverse sort, stack is as follows
[4, 3, 2, 1]
BUILD SUCCESSFUL (total time: 0 seconds)
*/
