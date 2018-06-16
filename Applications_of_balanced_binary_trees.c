// C program to insert a node in AVL tree
#include<stdio.h>
#include<stdlib.h>
 
// An AVL tree node
struct Node
{
    int key;
    struct Node *left;
    struct Node *right;
    int height;
    int nChildren;
    int tsum;
    int mingap;
};
 
// A utility function to get maximum of two integers
int max(int a, int b);
 
// A utility function to get height of the tree
int height(struct Node *N)
{
    if (N == NULL)
        return 0;
    return N->height;
}
 
// A utility function to get maximum of two integers
int max(int a, int b)
{
    return (a > b)? a : b;
}
 
/* Helper function that allocates a new node with the given key and
    NULL left and right pointers. */
struct Node* newNode(int key)
{
    struct Node* node = (struct Node*)
                        malloc(sizeof(struct Node));
    node->key   = key;
    node->left   = NULL;
    node->right  = NULL;
    node->height = 1;  // new node is initially added at leaf
    node->nChildren=0;
    node->tsum=0;
    node->mingap=1000;
    return(node);
}
 
// A utility function to right rotate subtree rooted with y
// See the diagram given above.
struct Node *rightRotate(struct Node *y)
{
    struct Node *x = y->left;
    struct Node *T2 = x->right;
 
    // Perform rotation
    x->right = y;
    y->left = T2;
 
    // Update heights
    y->height = max(height(y->left), height(y->right))+1;
    x->height = max(height(x->left), height(x->right))+1;
 
    // Return new root
    return x;
}
 
// A utility function to left rotate subtree rooted with x
// See the diagram given above.
struct Node *leftRotate(struct Node *x)
{
    struct Node *y = x->right;
    struct Node *T2 = y->left;
 
    // Perform rotation
    y->left = x;
    x->right = T2;
 
    //  Update heights
    x->height = max(height(x->left), height(x->right))+1;
    y->height = max(height(y->left), height(y->right))+1;
 
    // Return new root
    return y;
}
 
// Get Balance factor of node N
int getBalance(struct Node *N)
{
    if (N == NULL)
        return 0;
    return height(N->left) - height(N->right);
}
 
// Recursive function to insert key in subtree rooted
// with node and returns new root of subtree.
struct Node* insert(struct Node* node, int key)
{
    /* 1.  Perform the normal BST insertion */
    if (node == NULL)
        return(newNode(key));
 
    if (key < node->key)
        node->left  = insert(node->left, key);
    else if (key > node->key)
        node->right = insert(node->right, key);
    else // Equal keys are not allowed in BST
        return node;
 
    /* 2. Update height of this ancestor node */
    node->height = 1 + max(height(node->left),
                           height(node->right));
 
    /* 3. Get the balance factor of this ancestor
          node to check whether this node became
          unbalanced */
    int balance = getBalance(node);
 
    // If this node becomes unbalanced, then
    // there are 4 cases
 
    // Left Left Case
    if (balance > 1 && key < node->left->key)
        return rightRotate(node);
 
    // Right Right Case
    if (balance < -1 && key > node->right->key)
        return leftRotate(node);
 
    // Left Right Case
    if (balance > 1 && key > node->left->key)
    {
        node->left =  leftRotate(node->left);
        return rightRotate(node);
    }
 
    // Right Left Case
    if (balance < -1 && key < node->right->key)
    {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

   
 
    /* return the (unchanged) node pointer */
    return node;
}
 
// A utility function to print preorder traversal
// of the tree.
// The function also prints height of every node
void preOrder(struct Node *root)
{
    if(root != NULL)
    {
        printf("%d ", root->nChildren);
        preOrder(root->left);
        preOrder(root->right);
    }
}

void preOrder_rank(struct Node *root)
{
    if(root != NULL)
    {
        printf("%d ", root->nChildren);
        preOrder_rank(root->left);
        preOrder_rank(root->right);
    }
}

 void InitChildren(struct Node* Node)
{
        if(!Node)
        {
                return;
        }
        else
        {       Node->nChildren = 1 + NumeberofNodeInTree(Node->left)+NumeberofNodeInTree(Node->right);
                InitChildren(Node->left);
                InitChildren(Node->right);
        }

}


int NumeberofNodeInTree(struct Node* Node)
{
        if(!Node)
        {
                return 0;
        }
        else
        {
                  return(1+NumeberofNodeInTree(Node->left)+NumeberofNodeInTree(Node->right));
        }
} 
//Initialize sum
 void InitSum(struct Node* Node)
{
        if(!Node)
        {
                return;
        }
        else
        {
                Node->tsum =Node->key + sum(Node->left) + sum(Node->right) ;
                InitSum(Node->left);
                InitSum(Node->right);
        }

}


int sum(struct Node* Node)
{
   
        if(!Node)
        {
                return 0;
        }
        else if (Node->left==NULL && Node->right==NULL)
           return Node->key;
        else
        {
                  return Node->key + sum(Node->left) + sum(Node->right);
        }
} 

//
// preorder sum
void preOrder_sum(struct Node *root)
{
    
    if(root != NULL)
    {
        printf("%d ", root->tsum);
        preOrder_sum(root->left);
        preOrder_sum(root->right);
    }
}

int findRank(struct Node* t,int k)
{
  if(t->right!=NULL){
  int r= t->right->nChildren;
  printf("\n%d",r);
if(r+1==k)
 return t->key;

else if(k>r+1)
  {
    k=k-(r+1);
    printf("\nnew rank to be calculated %d",k);
    findRank(t->left,k);
  }
else
  findRank(t->right,k);
}

else
  return t->key;
  //return 0;
}
 
//Reverse_rank

int findReverseRank(struct Node* t,int x)
{
  
 if(t->key==x)
   {
   return (t->right!=NULL)?(t->right->nChildren+1):(t->nChildren);
   } 
else if(t->key<x)
   findReverseRank(t->right,x);
 else
  { 
    
    return (t->right->nChildren+1) + findReverseRank(t->left,x);
  }
}

//prefix sum
 int a=0;
 int *s=&a;
int prefixSum(struct Node* t,int x)
{
  
  if(t->key==x)
   return (t->left!=NULL)? (*s+t->left->tsum+t->key):(*s+t->key);
 else if(t->key<x)
  {
    (t->left!=NULL)? (*s=*s+t->key+t->left->tsum):(*s=*s+t->key);
    prefixSum(t->right,x);
  }
 else
  {
   prefixSum(t->left,x); 
  }
 
}

int min(a,b,c,d)
 {
   int p= (a<b)?(a<c?a:c):(b<c?b:c);
   return (p<d)?p:d;
 }

int mint(struct Node* t)
{
 struct Node* temp;
 while(t)
  {
    temp= t;
    t=t->left;
  }
 return temp->key;
}

int maxt(struct Node* t)
{
struct Node* temp;
 while(t)
  {
    temp= t;
    t=t->right;
  }
 return temp->key;
}

//INit mingap
int InitMingap(struct Node* t)
{
 if(t->left==NULL && t->right==NULL){
  //printf("%d ",t->key);
  return t->key;
}
 else if(t->left!=NULL &&t->right!=NULL)
 t->mingap= min(InitMingap(t->left),InitMingap(t->right),t->key-maxt(t->left),mint(t->right)-t->key);
 else if (t->left==NULL && t->right!=NULL)
  t->mingap= min(1000,InitMingap(t->right),1000,mint(t->right)-t->key);
 else
   t->mingap= min(InitMingap(t->left),1000,t->key-maxt(t->left),1000);
}

int min_gap=1000;
int *ptr_min_gap=&min_gap;
preOrder_mingap(struct Node* root)
 {
  
    
    if(root != NULL)
    {
        if(root->mingap<=*ptr_min_gap)
          *ptr_min_gap=root->mingap;
        printf("%d ", root->mingap);
        preOrder_mingap(root->left);
        preOrder_mingap(root->right);
    }
   
 }

 /* Given a non-empty binary search tree, return the
   node with minimum key value found in that tree.
   Note that the entire tree does not need to be
   searched. */
struct Node * minValueNode(struct Node* node)
{
    struct Node* current = node;
 
    /* loop down to find the leftmost leaf */
    while (current->left != NULL)
        current = current->left;
 
    return current;
}
 
// Recursive function to delete a node with given key
// from subtree with given root. It returns root of
// the modified subtree.
struct Node* deleteNode(struct Node* root, int key)
{
    // STEP 1: PERFORM STANDARD BST DELETE
 
    if (root == NULL)
        return root;
 
    // If the key to be deleted is smaller than the
    // root's key, then it lies in left subtree
    if ( key < root->key )
        root->left = deleteNode(root->left, key);
 
    // If the key to be deleted is greater than the
    // root's key, then it lies in right subtree
    else if( key > root->key )
        root->right = deleteNode(root->right, key);
 
    // if key is same as root's key, then This is
    // the node to be deleted
    else
    {
        // node with only one child or no child
        if( (root->left == NULL) || (root->right == NULL) )
        {
            struct Node *temp = root->left ? root->left :
                                             root->right;
 
            // No child case
            if (temp == NULL)
            {
                temp = root;
                root = NULL;
            }
            else // One child case
             *root = *temp; // Copy the contents of
                            // the non-empty child
            free(temp);
        }
        else
        {
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            struct Node* temp = minValueNode(root->right);
 
            // Copy the inorder successor's data to this node
            root->key = temp->key;
 
            // Delete the inorder successor
            root->right = deleteNode(root->right, temp->key);
        }
    }
 
    // If the tree had only one node then return
    if (root == NULL)
      return root;
 
    // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
    root->height = 1 + max(height(root->left),
                           height(root->right));
 
    // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to
    // check whether this node became unbalanced)
    int balance = getBalance(root);
 
    // If this node becomes unbalanced, then there are 4 cases
 
    // Left Left Case
    if (balance > 1 && getBalance(root->left) >= 0)
        return rightRotate(root);
 
    // Left Right Case
    if (balance > 1 && getBalance(root->left) < 0)
    {
        root->left =  leftRotate(root->left);
        return rightRotate(root);
    }
 
    // Right Right Case
    if (balance < -1 && getBalance(root->right) <= 0)
        return leftRotate(root);
 
    // Right Left Case
    if (balance < -1 && getBalance(root->right) > 0)
    {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }
 
    return root;
}

 void short_circuit(struct Node* root)
  {
   if(root!=NULL)
    {
     
        root->mingap=1000;
        short_circuit(root->left);
        short_circuit(root->right);
    }
  }

//preorder print
void preorder_print(struct Node* root)
  {
    
      if(root!=NULL)
    {
        printf("%d ",root->key);
        preorder_print(root->left);
        preorder_print(root->right);
    }
  }


/* Drier program to test above function*/
int main()
{
  struct Node *root = NULL;
 
  /* Constructing tree given in the above figure */
  root = insert(root, 10);
  root = insert(root, 20);
  root = insert(root, 30);
  root = insert(root, 40);
  root = insert(root, 50);
  root = insert(root, 26);
 
  
  /* The constructed AVL Tree would be
            30
           /  \
         20   40
        /  \     \
       10  25    50
  */
 
  
 printf("Preorder traversal of the constructed AVL"
         " tree is \n");
preorder_print(root);  
 
 
 
 printf("\n\n");
InitChildren(root); 
 preOrder(root);
printf("\nnumber at requested rank is %d",findRank(root,4));

//reverse rank
 printf("\nrank of given number is %d",findReverseRank(root,40));

//number of elements between X and Y(say 20,50);
 
printf("\nnumbers between x and y are %d",findReverseRank(root,20)-findReverseRank(root,40));

 InitSum(root);
 printf("\nSum");
 preOrder_sum(root);

//prefix sum
int p1=prefixSum(root,20);
*s=0;
int p2=prefixSum(root,10);
printf("\nsum between X and Y is %d",p1-p2);
printf("\n\n");

//MINGAP
InitMingap(root);
printf("\nMingaps");
preOrder_mingap(root);
printf("\nresulatnt mingap is %d ",*ptr_min_gap);
*ptr_min_gap=1000;
root= deleteNode(root, 30);
 printf("Preorder traversal of the constructed AVL after deletion is tree is \n");
preorder_print(root);  

short_circuit(root);
InitMingap(root);
printf("\nMingaps");
preOrder_mingap(root);
printf("\nresulatnt mingap is %d ",*ptr_min_gap);

//preorder_print(root);
  return 0;
}

/*
OUTPUT
shivam@shivam-Inspiron-3558:~/Downloads$ ./a.out
Preorder traversal of the constructed AVL tree is 
30 20 10 26 40 50 

6 3 1 1 2 1 
2
new rank to be calculated 1
1
number at requested rank is 26
rank of given number is 2
numbers between x and y are 3
Sum176 56 10 26 90 50 
sum between X and Y is 20


Mingaps4 6 1000 1000 10 1000 
resulatnt mingap is 4 Preorder traversal of the constructed AVL after deletion is tree is 
40 20 10 26 50 
Mingaps6 6 1000 1000 1000 
resulatnt mingap is 6
*/
