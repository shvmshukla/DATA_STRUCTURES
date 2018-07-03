/*
Given a Binary Tree and a sum s, your task is to check whether there is a root to leaf path in that tree with the 
following sum .You are required to complete the function hasPathSum.

https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/1
*/
-------------------------------------------------------------------------------------------------------------------------------

bool hasPathSum_sec(struct Node* node, int sum,int subSum)
{
  bool ans;    
  if (node == NULL)
  {
     return  0;
  }
  
  else
  {
     ans = 0;  
  
    /* otherwise check both subtrees */
     subSum += node->data;
  
    /* If reach a leaf node and sum becomes 0 then return true*/
    if ( subSum == sum && node->left == NULL && node->right == NULL )
      return 1;
    if ( subSum != sum && node->left == NULL && node->right == NULL )
      return 0;  
  
    
ans = ans || hasPathSum_sec(node->left,sum,subSum) || hasPathSum_sec(node->right,sum, subSum);
  }  
  
    return ans;  
}

bool hasPathSum(struct Node* node, int sum)
{
  /* return true if we run out of tree and sum==0 */
  return hasPathSum_sec(node,sum,0);
  
}
