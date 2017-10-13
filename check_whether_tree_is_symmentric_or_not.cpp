/*
Structure of the node of the tree is as
struct Node
{
	int key;
	struct Node* left, *right;
};
*/
// complete this function
// return true/false if the is Symmetric or not
bool isSym(struct Node* root1,struct Node* root2)
{
    if(root1==NULL&&root2==NULL)
    return true;
    if((root1)&&(root2)&&(root1->key==root2->key))
    return (isSym(root1->left,root2->right)&&isSym(root1->right,root2->left));

    return false;
}
bool isSymmetric(struct Node* root)
{
	// Code here
	return isSym(root,root);
}
