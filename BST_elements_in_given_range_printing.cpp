/*
Given a Binary Search Tree (BST) and a range, print all the numbers in the BST that lie in the given range. 
https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
*/

void printNearNodes(Node *root, int l, int h)
{
 
      if(root==NULL) return ;
       printNearNodes(root->left,l,h);
      if(root->data>=l&&root->data<=h)
      cout<<root->data<<" ";
       printNearNodes(root->right,l,h);
}

//Time Complexity: O(n) where n is the total number of keys in tree.
