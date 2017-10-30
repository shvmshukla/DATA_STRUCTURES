/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class rod_cutting {
    
   static int max(int a,int b)
    {
        return a>b?a:b;
    }
    public static void main(String[] args) {
        int len=5;
        int price[]={2,5,7,8};
        int r= price.length,i,j;        
     int t[][]=new int[r+1][len+1];
    
     for(i=0;i<=len;i++)
     {
         t[0][i]=0;
     }
     for(i=0;i<=r;i++)
     {
         t[i][0]=0;
     }
     for(i=1;i<=r;i++)
     {
         for(j=1;j<=len;j++)
         {
             
             if(i>j)
             {
                 t[i][j]=t[i-1][j];
        
             else
             {
                 t[i][j]=max(t[i-1][j],price[i-1]+t[i][j-i]);
      
             }
         }
     }
     System.out.println("dp array is ");
     for(i=0;i<=r;i++)
     {
         for(j=0;j<=len;j++)
         {
             System.out.print(t[i][j]+"  ");
         }
         System.out.println("");
     }
        System.out.println("max value that can be obtained is "+t[r-1][len]); 
    }
    
}
