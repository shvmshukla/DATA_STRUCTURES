/*
Given a string that contains ternary expressions. The expressions may be nested,task is convert the given ternary expression
to a binary Tree and return the root.

https://practice.geeksforgeeks.org/problems/convert-ternary-expression-to-binary-tree/1
*/

//simple solution using stack //
Node *convertExpression(string str,int i)
{
int n=str.length();
stack<Node*>s;
Node*temp1=(Node*)malloc(sizeof(Node));
temp1->data=str[0];
temp1->left=NULL;
temp1->right=NULL;
s.push(temp1);
Node*root=temp1; 
for(int i=1;i<n;i++){ 
    if(str[i-1]=='?'){
        Node*temp=(Node*)malloc(sizeof(Node)); 
        temp->data=str[i];
        temp->left=NULL;
        temp->right=NULL;
        temp1=s.top();
        temp1->left=temp;
        s.push(temp);
    }
    else if(str[i-1]==':'){
        Node *temp=(Node*)malloc(sizeof(Node));
        temp->data=str[i];
        temp->left=NULL;
        temp->right=NULL;
        s.pop();
        temp1=s.top();
        temp1->right=temp;
        s.pop();
        s.push(temp);
    }
}
return root;
}


//you can also do it using recursion but i have not done that (i was stuck:p)
