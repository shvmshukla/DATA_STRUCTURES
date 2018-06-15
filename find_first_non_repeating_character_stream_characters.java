/*
https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
Given an input stream of n characters consisting only of small case alphabets the task is to find the first non repeating
character each time a character is inserted to the stream. If no non repeating element is found print -1.

Example

Flow in stream : a, a, b, c
a goes to stream : 1st non repeating element a (a)
a goes to stream : no non repeating element -1 (a, a)
b goes to stream : 1st non repeating element is b (a, a, b)
c goes to stream : 1st non repeating element is b (a, a, b, c)

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class first_no_repeting_character_in_a_stream {
	public static void main (String[] args) {
		//code
	 Scanner sc= new Scanner(System.in);
	 
	 int t=sc.nextInt();
	 while(t-->0)
	 {
             int n=sc.nextInt();
	     Queue<Character> q= new LinkedList<Character>();
	     //char =sc.next().charAt(0);
             int count[]= new int[26];
             Arrays.fill(count,0);
	     for(int i=0;i<n;i++)
	     {
                
	         char c= sc.next().charAt(0);
	         if(q.isEmpty())
	         {
                    ; 
                   if(count[c-'a']==0)
                   {  
	           System.out.print(c+" ");
	           q.add(c);
                   count[c-'a']+=1;
                   }
                   else
                   {   count[c-'a']+=1;
                       System.out.print(-1+" ");
                   }
	         }
	         else
	         {
                
	             if(q.contains(c))
	             {
                         count[c-'a']+=1;
	                 q.remove(c);
                
	                 if(q.isEmpty())
	                 {
               
	                     System.out.print(-1+" ");
                
	                 }
                         else if(!(count[q.peek()-'a']>1))
	                 {
                            
	                      System.out.print(q.peek()+" ");
	                 }
                         else
                             System.out.print(-1+". ");
	             }
	             else
	                 {
	                     q.add(c);
	                     System.out.print(q.peek()+" ");
                             count[c-'a']+=1;
	                 }
	         }
	              
	             
	     }
	     
	 }
		
	}
}
