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
