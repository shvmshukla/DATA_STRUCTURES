bool isPalindrome(Node *head)
{
 Node* temp=head;
 int count=0;
 bool var=true;
 while(temp){
     temp=temp->next;
     count++;
 }
 for(int i=1;i<=count/2;i++){
     int l=count-i;
     Node *temp1=head,*temp2=head;
     for(int j=1;j<i;j++){
         temp1=temp1->next;
     }
     for(int j=1;j<=l;j++){
         temp2=temp2->next;
     }
     if(temp1->data!=temp2->data){
         var=false;
     }
 }
 if(var){
     return true;
 }
 else 
 return false;
}
