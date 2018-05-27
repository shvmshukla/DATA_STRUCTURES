/*
Given a linked list of size N, your task is to complete the function countNodesinLoop() that checks 
whether a given Linked List contains loop or not 
and if loop is present then return the count of nodes in loop or else return 0.
https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
*/

int countNodesinLoop(struct Node *head)
{
     // Code here
     int len=0,flag=0;
     struct Node*temp1=head,*temp2=head;
      
     while(temp1!=NULL && temp2!=NULL && temp2->next!=NULL )
     {
        temp1=temp1->next;
        temp2=temp2->next->next;
        if(temp1==temp2){
         flag=1;
         break;
        }
     }
   if(flag==1){     
    while(temp1->next!=temp2)
    {
        len++;
        temp1=temp1->next;
    }
    return len+1;
   }
   else
   return 0;
    
}
