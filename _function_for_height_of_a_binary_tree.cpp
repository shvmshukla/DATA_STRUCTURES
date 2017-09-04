you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Tree node structure  used in the program
 struct Node
 {
     int data;
     Node* left, *right;
}; */
/* Computes the height of binary tree with given root.  */
int height(Node* node)
{
   // Your code here
   int c,l,r;
   if(node==NULL)
    return 0;
    else
    {
        l= height(node->left)+1;
        r=height(node->right)+1;
        
    }
    
    (l>r)?c=l:c=r;
 
 return c;    
}
