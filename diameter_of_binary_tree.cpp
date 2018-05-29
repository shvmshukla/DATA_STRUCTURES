/*
Given a Binary Tree, find diameter of it.  The diameter of a tree is the number of nodes on the longest path between 
two leaves in the tree. 
*/
#########################################################################################################################
METHOD1: TIME COMPEXITY O(n^2)

int height(Node *root)   //called function
{
     if(root==NULL) return 0;
     if(root->right==NULL&&root->left==NULL)
      return 1;
      return 1+max(height(root->left), height(root->right));
      
}

int diameter(Node* node) //caller function
{
if(node==NULL) return 0;
return(max (height(node->left)+height(node->right)+1 , max( diameter(node->left),diameter(node->right) ) ));
    
   // Your code here
}
###########################################################################################################################

