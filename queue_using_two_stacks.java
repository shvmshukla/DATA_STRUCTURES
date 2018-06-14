class GfG
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    /* The method insert to push element into the queue */
    void insert(int B)
    {
      s1.add(B);
    }
	
    
    /*The method remove which return the element popped out of the queue*/
    int remove()
    {
	   //s2.addAll(s1);
	    while(!s1.isEmpty())
	     {
	       s2.push(s1.pop());
	     }
	  
    if(s2.isEmpty())
	   return -1;
	  
	 int popped=s2.pop();
	 s1.clear();
	 
   while(!s2.isEmpty())
	 {
	     s1.push(s2.pop());
	 }
	
	 return popped;
    }
}
