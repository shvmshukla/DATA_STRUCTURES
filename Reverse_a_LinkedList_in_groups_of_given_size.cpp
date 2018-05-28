/*
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
*/

struct node *reverse (struct node *head, int k)
{ 
  // Complete this method
   
  struct node* current = head;
    struct node* next = NULL;
    struct node* prev = NULL;
    int count = 0;   
    
    /*reverse first k nodes of the linked list */ 
    while (current != NULL && count < k)
    {
        next  = current->next;
        current->next = prev;
        prev = current;
        current = next;
        count++;
    }
    
    /* next is now a pointer to (k+1)th node 
       Recursively call for the list starting from current.
       And make rest of the list as next of first node */
    if (next !=  NULL)
       head->next = reverse(next, k); 

    /* prev is new head of the input list */
    return prev;
  
}
