/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// size of knapsack weight 8  
/**
 *
 * @author shivam
 */
public class knapsack_space_efficient {

    public static int max(int a,int b )
 {
     return a>=b? a:b;
 }
    public static void main(String[] args) {
        
    
    int t[]= new int[9];
   int value[]={12,10,21,15};
   int weight[]={2,1,3,2};
   
 
  System.out.println("Dynamic 2D dp array is:- ");        
  for(int i=0;i<4;i++){
      for(int j=8;j>=weight[i];j--)
      {
         t[j]= max(t[j],value[i]+t[j-weight[i]]);
          System.out.print(t[j]+"    ");
      }
      System.out.println(""); 
  }
  
  
        System.out.println("MAximum profit by 0-1 knapsack is "+t[8]);

        

}
}   
