/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


//User function Template for C++
/* A binary tree node has data, pointer to left child
   and a pointer to right child  
struct Node
{
    int data;
    Node* left;
    Node* right;
}; */
/* Should return count of leaves. For example, return
    value should be 2 for following tree.
         10
      /      \ 
   20       30 */
int countLeaves(Node* a)
{
  // Your code here
 
    if (a==NULL)
     return 0;
    
    if(a->left==NULL && a->right==NULL)   //this will be true only in case of leaf node
      return 1;
 
     
 return countLeaves(a->left)+countLeaves(a->right);
    
}
