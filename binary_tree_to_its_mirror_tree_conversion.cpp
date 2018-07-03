/*
Given a Binary Tree, convert it into its mirror.
https://practice.geeksforgeeks.org/problems/mirror-tree/1
*/
-------------------------------------------------------------------------------------------------------------------------------

void mirror(Node* node) 
{
     // Your Code Here
     Node *temp;
    if(node)
    { 
     mirror(node->left);
     mirror(node->right);
     
        temp= node->left;
        node->left=node->right;
        node->right=temp;
    }
 
}
