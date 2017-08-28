Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


//function Template for C++
/* Linked List Node structure
   struct Node  {
     int data;
     Node *next;
  }
*/
// Should reverse list and return new head. 1 2 3 4 5 6
Node* reverse(Node *head)
{
  // Your code here
  
  Node* temp= head;
  Node* previous=head;
  Node* current=head->next;
  
 temp=temp->next;
  while(temp!=NULL)
  {
      temp=temp->next;
      current->next=previous;  
      previous=current;
      current=temp;
      
  }
 head=temp; 
 return head; 
}
