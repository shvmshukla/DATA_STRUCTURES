/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class knapsack_zero_one {
    public static void main(String[] args) {
        
    
    int t[][]= new int[5][8];
   int value[]={1,4,5,7};
   int weight[]={1,3,4,5};
   for(int i=0;i<4;i++)
   {
       t[i][0]=0;
   }
   
   for(int j=0;j<8;j++)
   {
       t[0][j]=0;
   }
   
   
  for(int i=1;i<=4;i++){
      for(int j=1;j<8;j++)
      {
         if(j<weight[i-1])
         {
             t[i][j]= t[i-1][j];
         }
         else
         {
             t[i][j]= t[i-1][j]>=value[i-1]+t[i-1][j-weight[i-1]] ? (t[i-1][j]):(value[i-1]+t[i-1][j-weight[i-1]]);
         }
      }
      
  }
  
  
        System.out.println("MAximum profit by 0-1 knapsack is "+t[3][7]);

        System.out.println("Dynamic 2D dp array is:- ");       
for(int i=0;i<5;i++)
 {
   for(int j=0;j<8;j++)
   {
       System.out.print(t[i][j]+"  ");
   }
     System.out.println("");
 }
    }
}
