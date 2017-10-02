you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A binary tree node
struct Node
{
    int data;
    Node* left, * right;
}; */
void leftUtil(Node *root,int level,int *max)
{
    if(root==NULL)
    return;
    if(*max<level)
    {
        printf("%d ",root->data);
        *max=level;
    }
    leftUtil(root->left,level+1,max);
    leftUtil(root->right,level+1,max);
}
// A wrapper over leftViewUtil()
void leftView(Node *root)
{
   // Your code here
   int max = 0;
   leftUtil(root, 1, &max);
}
