/*
https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/
NOTE: this program also covers deletion of node if it is either at the beginning of circular list or at the end.
*/

void deleteNode(struct Node *head, int key)
{
// Your code goes here
 struct Node* temp=head,*prev=head;
 
if(head==NULL)
 return;
 
if(temp->data==key)
{
    prev=head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }
    
    temp->next=temp->next->next;
    head=temp->next;
    return;
}

else{
    
  temp=temp->next;
 while(temp!=head)
 {
     
     if(temp->data==key)
     {
        prev->next=temp->next;
         free(temp);
         break;
     }
     prev=temp;
    temp=temp->next;
    
  }
 } 
}

/*
OUTPUT
For Input:
10 8 7 5 2
8
Your Output is:
10 7 5 2 

*/
