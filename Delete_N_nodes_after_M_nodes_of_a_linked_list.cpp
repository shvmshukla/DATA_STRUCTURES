/*
Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.

Input:

Complete the method which takes three argument: the head of the linked list,M an N. Function should not read any input from stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list. 
There are multiple test cases. For each test case, this method will be called individually.
 

Output:

Function should not print any output to stdin/console
 

Example:

M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
After 2 nodes 2 nodes will be deleted.Deleted Nodes 3->4 and 7->8
Output: Linked List: 1->2->5->6

For Testing use this format:
1 (Test case)
8 (Number of elements in linked list)
2 1(M and N)
9 1 3 5 9 4 10 1 (8 Number)
output : 9 1 5 9 10 1 
*/

void linkdelete(struct node  *head, int M, int N)
{
    struct node *p=head;
    int k=M,j=N;
    while(p!=NULL){
        k--;
        if(k==0){
            while(p->next!=NULL && j--){
                p->next=p->next->next;
                //p=p->next;
            }
            j=N;
            k=M;
            p=p->next;
        }
        else{
            p=p->next;
        }
        
    }
    
}
