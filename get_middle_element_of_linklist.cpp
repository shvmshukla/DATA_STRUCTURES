/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Link list Node 
struct Node {
    int data;
    Node* next;
}; */
/* Should return data of middle node. If linked list is empty, then  -1*/
int getMiddle(Node *head)
{
   // Your code here
 struct  node *p,*q;
   p=head;
   q=head;
   while(q && q->next)
  { 
   p=p->next;
   q=q->next->next;
}
return p;
}
