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
int countLeaves(struct node* a)
{
  static int count=0;
    /*1. empty */
    if (a==NULL)
      {
              return 0;
      }
    else if(a->left==NULL && a->right==NULL)   //this will be true only in case of leaf node
     {
     
       count++;
     }
    else
      {
        countLeaves(a->left); 
        countLeaves(a->right);
      }
 
     
 return count;
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
