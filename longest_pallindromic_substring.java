//NOTE: do this code after understanding code of longest_pallindromic_subsequence.java for better understanding.
//https://www.youtube.com/watch?v=tABtJbLOQho


public class longest_pallindromic_substring {
    
   static int max(int a,int b)
   {
       return a>b?a:b;
   }
    public static void main(String[] args) {
      String s="agbdba";
      int len=s.length(),i,j,l;
      boolean t[][]= new boolean[len][len];
      int max=1;  //max will store the max length of pallindromic substring so far 
      for(i=0;i<len;i++)
      {
          t[i][i]=true;
      }
     for(l=2;l<=len;l++)
     {
         for(i=0;i<s.length()-l+1;i++)
         {
             j=i+l-1;
            // System.out.println(i+":"+j);
             if(s.charAt(i)==s.charAt(j))
             {
                 if(t[i+1][j-1]==true)
                 {    
                  t[i][j]=true;
                  if(j-i+1>=max)
                      max=j-i+1;
                 }
                 else
                   t[i][j]=false;  
             }
             else
             {
                 t[i][j]=false;
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
        System.out.println("max value that can be obtained is "+max); 
    }
      
}

/*
run:
dp array is 
true  false  false  false  false  false  
false  true  false  false  false  false  
false  false  true  false  true  false  
false  false  false  true  false  false  
false  false  false  false  true  false  
false  false  false  false  false  true  
max value that can be obtained is 3
BUILD SUCCESSFUL (total time: 0 seconds)
*/
