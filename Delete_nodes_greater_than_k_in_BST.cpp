/*
Given a BST and a value x(here key) the task is to delete the nodes having values greater than or equal to x.
https://practice.geeksforgeeks.org/problems/delete-nodes-greater-than-k/1
*/

Node *deleteNode(Node *root,int key)
{
          if(root==NULL)
             return NULL;
            root->left=deleteNode(root->left,key);
             root->right=deleteNode(root->right,key);
             if(root->data>=key)
             {
                 return root->left;
             }
             return root;  
}

//time complexity O(n)
