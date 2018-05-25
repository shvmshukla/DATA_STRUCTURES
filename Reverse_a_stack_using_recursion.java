/*
Reverse a stack using recursion
Write a program to reverse a stack using recursion. You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

https://www.cdn.geeksforgeeks.org/reverse-a-stack-using-recursion/
*/
// NOTE: a good code to understand recursion in deep as well
/**
 *
 * @author shivam
 */

import java.util.Stack;
public class reverse_sort_a_stack_using_recursion {
    static Stack<Integer> stack= new Stack<Integer>();
   
    static void  insert_at_bottom(int x)
    {
       if(stack.isEmpty())
       {
          stack.push(x); 
       }
       else
       {
           
               int temp= stack.peek();
               stack.pop();
               insert_at_bottom(x);
               stack.push(temp);
           
           
       }
    }
    
    static void  reverse()
    {
        if(stack.isEmpty()!=true)
        {
            
        
       
        int  a=stack.peek();
         stack.pop();
         reverse();
         insert_at_bottom(a);
       
        }  
    }
    
    //driver
    public static void main(String[] args) {
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("original stack is as follows");
        System.out.println(stack);
        
       reverse();
   
        System.out.println("After reverse sort, stack is as follows");
        System.out.println(stack); 
        
        
        
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
