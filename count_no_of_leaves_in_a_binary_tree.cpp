#include <stdio.h>
#include <stdlib.h>
 
/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct node
{
    int data;
    struct node* left;
    struct node* right;
};
 
/* Helper function that allocates a new node with the
   given data and NULL left and right pointers. */
struct node* newNode(int data)
{
    struct node* node = (struct node*)
                             malloc(sizeof(struct node));
    node->data  = data;
    node->left  = NULL;
    node->right = NULL;
 
    return(node);
}
 
/* Fucntion to count two leaves */

int countLeaves(Node* root)
{
  // Your code here
  if(!root) return 0;
  if(root->left == NULL && root->right == NULL) return 1;
  int l = countLeaves(root->left);
  int r = countLeaves(root->right);
  return l+r;
}

/* Driver program to test identicalTrees function*/
int main()
{
    struct node *root1 = newNode(1);

    root1->left = newNode(2);
    root1->right = newNode(3);
    root1->right->right = newNode(2);
    root1->left->left  = newNode(4);
    root1->left->right = newNode(5); 
 
    int leaves= countLeaves(root1);
        printf("number of Leaves are %d ",leaves);
    
    getchar();
  return 0;
}
