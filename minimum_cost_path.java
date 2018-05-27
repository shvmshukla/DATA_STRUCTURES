/*
https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of 
minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
You can only traverse down, right and diagonally lower cells from a given cell, i.e.,
from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
You may assume that all costs are positive integers.

*/

public class min_cost_path {
    public static void main(String args[]){
       
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};
        int m,n;// 3,2
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the destination coordinates");
        m=sc.nextInt();
        n=sc.nextInt();
       int dp[][]= new int[m+1][n+1]; 
       int sum=0;
       //initiation
       for(int i=0;i<=n;i++)
       {
           dp[0][i]=sum+cost[0][i];
           sum=dp[0][i];
       }
       sum=0;
       
       for(int i=0;i<=m;i++)
       {
          dp[i][0]=sum+cost[i][0];
          sum=dp[i][0];
       }
      //propagate the dp[][] matrix
      for(int i=1;i<=m;i++)
      {
          for(int j=1;j<=n;j++)
          {
              dp[i][j]=cost[i][j]+ min(dp[i-1][j-1], dp[i-1][j],dp[i][j-1]);
          }
      }
      for(int i=0;i<=m;i++)
      {
          for(int j=0;j<=n;j++)
          {
              System.out.print(dp[i][j]+"  ");
          }
          System.out.println("");
      }
        System.out.println("minimum cost path has cost="+dp[m][n]);
    }

    static int min(int a,int b,int c)
    {
     int min1=Math.min(a,b);
     int min=Math.min(min1,c);
             
    return min;
    }
    
}

/*
OUTPUT
run:
Enter the destination coordinates
3 // m
2 // n
//dp[][]
1  3  6  
5  9  5  
6  10  8  
12  8  17<--(3,2)ans  
minimum cost path has cost=17
BUILD SUCCESSFUL (total time: 2 seconds)

*/
