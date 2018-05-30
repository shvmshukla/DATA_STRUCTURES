/*
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
*/

int sum(Node *root)
{if(root==NULL) return 0;
 return root->data+max(sum(root->left),sum(root->right));
}

int maxPathSum(struct Node *root)
{if(root==NULL) return 0;
return max(sum( root->left)+sum(root->right)+root->data ,max( maxPathSum(root->left), maxPathSum(root->right) ) );
    

}

//time complexity O(n)
