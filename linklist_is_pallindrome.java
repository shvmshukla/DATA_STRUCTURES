import java.util.Collection;
import java.util.LinkedList;
public class linked_list_is_pallindrome {
   
    public static void main(String[] args) {
        LinkedList<Integer> ll= new LinkedList<Integer>();
        
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(30);
        ll.add(20);
        ll.add(10);
       int len=ll.size();
             
     for(int i=0;i<len/2;i++)
     {
       if(ll.get(i)!=ll.get(len-i-1))
       {
           System.out.println("not pallindrome");
           break;
       }
       else
           continue;
     }
        System.out.println("pallindrome");
   
    }
  
}

/*
run:
pallindrome
BUILD SUCCESSFUL (total time: 0 seconds)

*/
