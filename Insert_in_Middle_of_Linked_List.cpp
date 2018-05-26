/*
Given a linked list of size N and a key, your task is to complete the function insertInMiddle(), that should insert the key in the middle of the linked list.

Input:
The function takes two argument as input, the reference pointer to the head of the linked list and an integer value key, the data to be inserted in the linked list.
There will be T, test cases and for each test case the function will be called separately.

Output:
For each test case the function should return the reference pointer to the head of the linked list.

Constraints:
1<=T<=100
1<=N<=103

Example:
Input:
2
3
1 2 4
3
4
10 20 40 50
30
Output:
1 2 3 4
10 20 30 40 50
*/

// function should insert node at the middle of the linked list

Node* insertInMiddle(Node* head, int x)
{
	// Code here
 struct Node* temp=head,*temp1=head;

//creating a new node which is to be added
 struct Node* add= (struct Node*)malloc(sizeof(Node));
    add->data=x;
    add->next=NULL;

	while(temp->next!=NULL && temp->next->next!=NULL)
	{
	    //prev=temp1;
	    temp=temp->next->next;
	    temp1=temp1->next;
	    
	}

	add->next=temp1->next;
	temp1->next=add;
	
	return head;
}
