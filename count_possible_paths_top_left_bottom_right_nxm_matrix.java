/*
http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
https://www.youtube.com/watch?v=GO5QHC_BmvM
*/

public class NumberOfPathsInMxNMatrix {
    //m=5  n=4 
    public static void main(String[] args) {
        int dp[][]=new int[5][4];   //new int[m][n];
        
       for(int i=0;i<dp.length;i++)
       {
           dp[i][0]=1;
       }
       for(int i=0;i<dp[0].length;i++)
       {
           dp[0][i]=1;
       }
       
      for(int i=1;i<dp.length;i++)
      {
          for(int j=1;j<dp[0].length;j++)
          {
              
            dp[i][j]=dp[i-1][j]+dp[i][j-1];  
          }
      }
      
        System.out.println("possible-paths-top-left-bottom-right-nxm-matrix are "+dp[4][3]);   //ans= dp[m-1][n-1]
    }
}

//time complexity O(mn)
