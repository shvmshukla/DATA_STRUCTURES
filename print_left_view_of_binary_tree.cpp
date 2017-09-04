/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A binary tree node
struct Node
{
    int data;
    Node* left, * right;
}; */
// A wrapper over leftViewUtil()
void lvw(Node *root,int l,int *m){
    if(root==NULL)
        return;
    if(*m<l){
        *m=l;
        cout <<root->data<<" ";
    }
    lvw(root->left,l+1,m);
    lvw(root->right,l+1,m);
    return;
}

void leftView(Node *root)
{
   // Your code here
   int m=0;
   lvw(root,1,&m);
}
