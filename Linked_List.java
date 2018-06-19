/**
 *
 * @author shivam
 */
class Node1
{
    int data;
    Node1 next;
}

public class LinkedList {

//-------------------------------------------------------------------------------------------------------------------------------    
    Node1 addNodeAtBegining(int value,Node1 head)
    {  
        Node1 node= new Node1();
        node.data= value;
        node.next=head;
        
        return node;
    }
//-------------------------------------------------------------------------------------------------------------------------------        
    Node1 addNodeAtLast(int value,Node1 head)
    {
     Node1 temp=head;
     Node1 node=new Node1();
     node.data= value;
     if(head==null)
     {
         node.next=null;
         head=node;
     }
     else{
     while(temp.next!=null)
     {
         temp=temp.next;
     }
     temp.next=node;
     node.next=null;
     }    
     return head;   
    }
//-------------------------------------------------------------------------------------------------------------------------------    
    Node1 reverseLinkedList(Node1 head)
    {
        if(head==null || head.next==null)
            return head;
        Node1 temp= head.next,temp1=head;
        Node1 previous= head;
        Node1 firstNode=head;
        while(temp1.next!=null)
        {
         temp1=temp.next;
         temp.next=previous;
         previous=temp;
         temp=temp1;
        }
        temp.next=previous;
        head=temp;
        firstNode.next=null;
        
        return head;
    }
//--------------------------------------------------------------------------------------------------------------------------    
    Node1 insertionSortLinkedList(Node1 head)
    {
        
        if(head==null ||head.next==null)
            return head;
        
        Node1 temp=head.next,first=head,previous=head,position=null;
        
        while(temp!=null)
        {
          if(temp.data<first.data)
          {
              previous.next=temp.next;
              temp.next=first;
              first=temp;
              head=first;
              temp=previous.next;
              continue;
              
          }
            
          if(temp.data>previous.data)
            {
                previous=temp;
                temp=temp.next;
                continue;
            }
          else
          {
           
              position = searchPositionToInsert(first,temp.data);
           
                        
                  previous.next=temp.next;
                  temp.next=position.next;
                  position.next=temp;
                  
              
            temp=previous.next;
             
          }    
        }
        
        
        return head;
    }
    
    Node1 searchPositionToInsert(Node1 head,int value)
    {
        Node1 temp=head.next;
        Node1 previous=head,position=null;
        while(temp!=null)
        {
            
            if(temp.data<value)
            {   previous=temp;
                temp=temp.next;   
            }
            else
            {
            position=previous;
            return position;
            }
        }
        System.out.println("hello");
        return head;
    }
//-------------------------------------------------------------------------------------------------------------------------------        
Node1 deleteDuplicate(Node1 head)
{
    //  1 1 1 22  22  34 55 55 78 
    if(head==null || head.next==null)
        return head;
    
    Node1 temp= head,previous=head;
     
    while(temp.next!=null)
      {
           if(temp.data==temp.next.data)
           {
            previous.next=temp.next.next;
           }
          else
           {
             previous=temp;
           }
            temp=previous.next; 
      }
    return head;
}

//-------------------------------------------------------------------------------------------------------------------------------    
    void printLinkedList(Node1 head)
    {
        
        Node1 temp= head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------        
  

    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        Node1 head= null;
     /*   head =  ll.addNodeAtBegining(50,head);
        head =  ll.addNodeAtBegining(40,head);
        head =  ll.addNodeAtBegining(30,head);
        head =  ll.addNodeAtBegining(20,head);
     */   
        head =  ll.addNodeAtLast(6,head);
        head =  ll.addNodeAtLast(72,head);
        head =  ll.addNodeAtLast(78,head);
        head =  ll.addNodeAtLast(11,head);
        head =  ll.addNodeAtLast(21,head);
        head =  ll.addNodeAtLast(2,head);
        head =  ll.addNodeAtLast(9,head);
        head =  ll.addNodeAtLast(6,head);
        head =  ll.addNodeAtLast(21,head);
        head =  ll.addNodeAtLast(9,head);
        head =  ll.addNodeAtLast(2,head);
        System.out.println("Linkedlist is ");
        ll.printLinkedList(head);
        System.out.println("");
        
        
        System.out.println("reversed linkedlist");
        head=ll.reverseLinkedList(head);
        ll.printLinkedList(head);
        System.out.println("");
        
        System.out.println("sorted linked list");
        head=ll.insertionSortLinkedList(head);
        ll.printLinkedList(head);
        System.out.println("");
        
        System.out.println("After Deleting Duplicate Elements");
        head =ll.deleteDuplicate(head);
        ll.printLinkedList(head);
        System.out.println("");
        
     
        
    }
}

/*
OUTPUT
run:
Linkedlist is 
6->72->78->11->21->2->9->6->21->9->2->
reversed linkedlist
2->9->21->6->9->2->21->11->78->72->6->
sorted linked list
2->2->6->6->9->9->11->21->21->72->78->
After Deleting Duplicate Elements
2->11->72->78->
BUILD SUCCESSFUL (total time: 0 seconds)

*/
