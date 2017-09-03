/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/
//  5 4    4 5 
//5 4 3  3 4 5

/*struct Node
{
    int data;
   Node* next;
}; */
//write a function returns the resultant linked list
Node*  addTwoLists(Node* first, Node* second){
  // Code here
  int count1=1,count2=1;
  int number1=0,number2=0;
  Node *temp=first, *temp1=second;
  
 //number1
 temp=first;
  while(temp!=NULL)
  {
      number1 +=(temp->data)*count1;        
      temp=temp->next;
      count1*=10;
  }
 // cout<<"n1 "<<number1;
  //number2
  temp1=second;
  while(temp1!=NULL)
  {
       number2 +=(temp1->data)*count2;        
      temp1=temp1->next;
      count2*=10;
  }
 // cout<<"n2 "<<number2;
 int sum= number1+number2;    // 3 9 0
 //cout<<"sum "<<sum;
 
 Node *temp2= (Node*) malloc(sizeof(Node));
 Node *end=NULL,*head;
 
 while(sum>0)
 {
     int r= sum%10;
     sum/=10;
     temp2->data= r;
     if(end==NULL)
    { 
     
     temp2->next=NULL;
     end=temp2;
     head=temp2;
    }
    else
    {   
        
        temp2->data=r;
        temp2->next=NULL;
        end->next=temp2;
         end=temp2;
    }
 }
 
 
 return head;
}


//EFFICIENT_CODE
/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*struct Node
{
    int data;
   Node* next;
}; */
//write a function returns the resultant linked list
Node*  addTwoLists(Node* first, Node* second){
    Node*temp=first;
    int c=0;
    Node*prev=first;
  while(first && second){
      first->data +=second->data;
      if(c==1){
          first->data+=1;
          c=0;
      }
      if(first->data >=10){
          c=1;
          first->data-=10;
      }
      prev=first;
      first=first->next;
      second=second->next;
  }
  while(first){
      if(c==1){
          first->data+=1;
          c=0;
      }
      if(first->data>=10){
          c=1;
          first->data-=10;
      }
      prev=first;
      first=first->next;
  }
  while(second){
      prev->next=new Node();
      prev->next->data=second->data;
      if(c==1){
          prev->next->data+=1;
          c=0;
      }
      if(prev->next->data>=10){
          c=1;
          prev->next->data-=10;
      }
      prev=prev->next;
      second=second->next;
  }
  
  if(c==1){
      prev->next=new Node();
      prev->next->data=1;
      prev=prev->next;
  }
  return temp;
}
