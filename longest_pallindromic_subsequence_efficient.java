/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
dp array is 
1  1  1  1  3  5  
0  1  1  1  3  3  
0  0  1  1  1  1  
0  0  0  1  1  1  
0  0  0  0  1  1  
0  0  0  0  0  1  

after space efficient 
1,1,1,1,1,1,
1,1,1,1,1,
1,1,1,1,
1,3,1,
3,3,
5, // final answer ... i have not printed it .. but you can do it by putting a condition while printing i.e. if(count+1==len)
//print(temp[i]) in every print statement;

*/


/**
 *
 * @author shivam
 */
public class longest_pallindromic_subsequence_efficient {
    static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static void main(String[] args) {
        String s= "abgdba";
        int len=s.length();
        int temp1[]=new int[len];
        int temp2[]=new int[len-1];
        int temp3[]=new int[len-2];
  int i,j,count=1,flag=1,column;
     for(i=0;i<len;i++)
     {
         temp1[i]=1;
         System.out.print(temp1[i]+",");
     }
        System.out.println("");
     for(i=0;i<len-1;i++)
     {
         if(s.charAt(i)==s.charAt(i+1)){
          temp2[i]=2;
         System.out.print(temp2[2]+",");
         }
         else{
           temp2[i]=1;
         System.out.print(temp2[i]+",");
         }
     }
        System.out.println("");
   flag=3;
   count=2;
  while(count<len)
  {
     if(flag==3)
     {
        column=count;
        for(i=0;i<len-count && column<len;i++)
        {
         if(s.charAt(i)==s.charAt(column)){
          temp3[i]=2+temp1[i+1];
             System.out.print(temp3[i]+",");
         }
         else{
           temp3[i]=max(temp2[i],temp2[i+1]);
           System.out.print(temp3[i]+",");
         }
       column++; 
        }
        System.out.println("");
     }
      
      
    if(flag==2)
      {
           column=count;
        for(i=0;i<len-count && column<len;i++)
        {
         if(s.charAt(i)==s.charAt(column)){
          temp2[i]=2+temp3[i+1];
         System.out.print(temp2[i]+",");
         }
         else
           temp2[i]=max(temp1[i],temp1[i+1]);{
            System.out.print(temp2[i]+",");
        }
       column++; 
        } 
       System.out.println(""); 
      }
      
     if(flag==1)
     {
           column=count;
        for(i=0;i<len-count && column<len;i++)
        {
         if(s.charAt(i)==s.charAt(column))
         {    
          temp1[i]=2+temp2[i+1];
          System.out.print(temp1[i]+",");
         } 
         else{
           temp1[i]=max(temp3[i],temp3[i+1]);
         System.out.print(temp1[i]+",");
         }
       column++; 
        }
        System.out.println("");
     }
       
    if(flag==3)
        flag=1;
    else
        flag+=1;
  count++;
  }
  
 }
    
}
