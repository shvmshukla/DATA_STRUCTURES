/*
Given a binary tree, your task is to complete the function minDepth which takes one argument the root of the binary tree and prints the min depth of  binary tree .

          1
       /    \
     2       3
   /        
 4       

For the tree above the min depth is 2 ie 1 3

https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1
*/
-------------------------------------------------------------------------------------------------------------------------------

int minDepth(Node *root)
{
    
         if(root==NULL) return 100000;
         if(root->left==NULL&&root->right==NULL) return 1;
         return 1+ min(minDepth(root->left), minDepth(root->right));
         
}
