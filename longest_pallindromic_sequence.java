/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shivam
 */
public class longest_pallindromic_sequence {
    
   static int max(int a,int b)
   {
       return a>b?a:b;
   }
    public static void main(String[] args) {
      String s="agbdba";
      int len=s.length(),i,j,l;
      int t[][]= new int[len][len];
      for(i=0;i<len;i++)
      {
          t[i][i]=1;
      }
     for(l=2;l<=len;l++)
     {
         for(i=0;i<s.length()-l+1;i++)
         {
             j=i+l-1;
             System.out.println(i+":"+j);
             if(s.charAt(i)==s.charAt(j))
             {
                 t[i][j]=2+t[i+1][j-1];
             }
             else
             {
                 t[i][j]=max(t[i][j-1],t[i+1][j]);
             }
         }
     }
     System.out.println("dp array is ");
     for(i=0;i<len;i++)
     {
         for(j=0;j<len;j++)
         {
             System.out.print(t[i][j]+"  ");
         }
         System.out.println("");
     }
        System.out.println("max value that can be obtained is "+t[0][len-1]); 
    }
      
}
