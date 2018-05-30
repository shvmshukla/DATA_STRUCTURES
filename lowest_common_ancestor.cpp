/*
Given a Binary Tree and 2 nodes value n1 and n2  , your task is to find the lowest common ancestor of the two nodes . 
You are required to complete the function LCA .
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
watch tushar roy for more detailed explaination

*/

Node * LCA(Node* root ,int n1 ,int n2 )
{
   //Your code here 
   if(root==NULL) return NULL;
   
   if(root->data==n1||root->data==n2) return root;
   
   Node *left=LCA(root->left,n1,n2);
   Node *right=LCA(root->right,n1,n2);
   
   if(left!=NULL&&right!=NULL) return root;
   
   if(left==NULL&&right==NULL) return NULL;
   
   if(left) return left;
   else  return right;
   
}

//time complexity O(n)
