//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
/*
Input:

You have to complete the method which takes two arguments as heads of two linked lists. 


Output:
The function should return data value of a node where two linked lists merge.  
If linked list do not merge at any point, then it shoudl return -1.

Constraints:
1 <=T<= 50
1 <=N<= 100
1 <=value<= 1000

Example:
Input:
2
2 3 2
10 20
30 40 50
5 10
2 3 0
10 20
30 40 50
First line is number of test cases. Every test case has four lines. 
First line of every test case contains three numbers, x (number of nodes before merge point in 1st list), 
y(number of nodes before merge point in 11nd list) and z (number of nodes after merge point).
Next three lines contain x, y and z values.

Output:
5
-1
*/

/* Should return data of intersection point of two linked
   lists head1 and head2.
   If there is no intersecting point, then return -1. */
int intersectPoint(Node* head1, Node* head2)
{
    // Your Code Here
    struct Node *temp1=head1,*temp2=head2;
    int len1=0,len2=0,diff;
    while(temp1!=NULL)
    {
        len1++;
        temp1=temp1->next;
    }
    
    while(temp2!=NULL)
    {
        len2++;
        temp2=temp2->next;
    }
 
 if(len1>len2)
 {
    diff=len1-len2;  
    temp1=head1;
  
      while(diff-->0)
        {
         temp1=temp1->next;  
        }
  
  temp2=head2;
     while(temp2!=NULL)
        {
          if(temp2==temp1)
            {
              return temp1->data;
            }
          else
          {
            temp2=temp2->next;
            temp1=temp1->next;
          }
  }
 }
else
  {
    diff=len2-len1;  
    temp2=head2;
  
      while(diff-->0)
        {
         temp2=temp2->next;  
        }
  
     temp1=head1;
     while(temp1!=NULL)
        {
          if(temp1==temp2)
            {
              return temp2->data;
            }
          else
          {
            temp1=temp1->next;
            temp2=temp2->next;
            
          }
  }
 } 
  return -1;
}
