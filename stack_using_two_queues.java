/*
https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
*/

class GfG
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
     int top=0;
/*The method pop which return the element poped out of the stack*/
int pop()
{
	if(q1.isEmpty())
	 return -1;
	 
   else
   {
    int x=top;  
	 while(!q1.isEmpty() &&top>1)
	 {
	   q2.add(q1.poll());
	   top--;
	 }
   int popped=q1.poll();
  
 // q1.addAll(q2);
    while(!q2.isEmpty())
	 {
	  q1.add(q2.poll());
	 }
  
  top=x-1;
   
  return popped;
   }
  
}
	
    /* The method push to push element into the stack */
    void push(int a)
    {
      q1.add(a);
	    top++;
    }
}
