
/*
Given a Binary Tree and a number k. Print all nodes that are at distance k from root (root is considered at distance 0 from
itself).  Nodes should be printed from left to right.
https://practice.geeksforgeeks.org/problems/k-distance-from-root/1
https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
*/

void printKdistance(Node *root, int k)
{
 
  if(root==NULL) return ;
  
  
  if(k==0)cout<<root->data<<" ";
  
  if(root->left!=NULL)
   printKdistance(root->left,k-1);
  
  
  if(root->right!=NULL)
  printKdistance(root->right,k-1);
  
}

//Time Complexity: O(n) where n is number of nodes in the given binary tree.
