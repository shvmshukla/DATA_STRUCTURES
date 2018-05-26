/*
Given a singly linked list, remove all the nodes which have a greater value on right side.

Input:
You have to complete the method which takes 1 argument: the head of the  linked list  .You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Output:
Your function should return a pointer to the linked list in which all nodes which have a greater value on right side are removed.

Constraints:
1<=T<=50
1<=size of linked list <=100
1<=element of linked list <=1000

Example:

Input:
3
8
12 15 10 11 5 6 2 3
6
10 20 30 40 50 60
6
60 50 40 30 20 10

Output:

15 11 6 3
60
60 50 40 30 20 10

*/


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
The structure of linked list is the following
struct Node
{
int data;
Node* next;
};
*/
//fun2 : called by fun1
void reverse(struct Node **head) {
	struct Node *current = *head;
	struct Node *prev = NULL;
	struct Node *next;
	while (current != NULL) {
		next = current->next;
		current->next = prev;
		prev = current;
		current = next;
	}
	*head = prev;
}

//fun1: driver
Node *compute(Node *head)
{
// your code goes here
    reverse(&head);
    struct Node *current = head;
	struct Node *maxnode = head;
	struct Node *temp;

	while(current != NULL && current->next != NULL) {
		if(current->next->data < maxnode->data) {
			temp = current->next;
			current->next = temp->next;
			free(temp);
		}
		else {
			current = current->next;
			maxnode = current;
		}
	}
	reverse(&head);
    return head;
}
