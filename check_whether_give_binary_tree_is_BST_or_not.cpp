void checkBST(Node *root,int &flag,int lb,int ub){
    if(root==NULL || flag==1){return;}
    if( (root->data > ub) || (lb > root->data) ){
        flag=1;return;
    }
    checkBST(root->left,flag,lb,root->data);
    checkBST(root->right,flag,root->data,ub);
}
bool isBST(Node* root) {
    int flag=0;
    checkBST(root,flag,INT_MIN,INT_MAX);
    if(!flag) return true;
    else return false;
}
