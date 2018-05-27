/*
Given a singly linked list, rearrange it in a way that all odd position nodes are together and all even positions node are together,

Input: You have to complete the method which takes one argument: the head of the linked list. You should not read any input from stdin/console.. 
Note: There are multiple test cases, for each test case, this method will be called individually.

Output:  
Your function should return pointer to head of the modified list.

Constraints:
1 <=T<= 50
1 <=N<= 100
1 <=value<= 1000

Example:
Input:
2
4
1 2 3 4
5
1 2 3 4 5

Output:
1 3 2 4
1 3 5 2 4
*/
//METHOD1:
Node *rearrangeEvenOdd(Node *head)
{
   // Your Code here
   Node *odd = head;
   Node *even = head->next;
   Node *next;
   Node *current = head;
   while(current && current->next)
   {
       next = current->next;
       current->next = next->next;
       current = next;
   }
   Node *temp = odd;
   while(odd->next)
   {
       odd = odd->next;
   }
   odd->next = even;
   return temp;
}
-------------------------------------------------------------------------------------------------------------------------
//METHOD2:
Node *rearrangeEvenOdd(Node *head)
{
   // Your Code here
 struct Node*temp=head,*prev=head,*end=head;
 
   int count =1,len=1,i=1;
   while(temp->next!=NULL)
   {
       temp=temp->next;
       len++;
   }
  // printf("%d",len);
   end=temp;
   temp=head;
   
   while(i<=len)
   {
      if(i%2==0 && temp->next!=NULL)
      {
      //  printf("%d",len);  
        int key=temp->data;
        prev->next=temp->next;
        temp=temp->next;
        //free(temp);
        
       struct Node* add= (struct Node*)malloc(sizeof(Node)); 
        add->data=key;
        add->next=NULL;
        
        end->next=add;
        end=add;
      }
      else
      {
       prev=temp; 
       temp=temp->next;
      }
      i++;
   }
   
   return head;
}
