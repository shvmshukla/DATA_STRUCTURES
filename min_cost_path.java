/*
https://www.youtube.com/watch?v=lBRtnuxg-gU&t=179s
https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

NOTE: [digonal \ ,left->right,aand top to bottom|] allowed 
*/
public class minimum_cost_path {
    
    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public static void main(String[] args) {
        
    
     int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};   
    
        int m=3,n=2;
        int temp[][] = new int[m+1][n+1];
        int sum = 0;
        for(int i=0; i <= n; i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
        System.out.println("minimum cost to reach at (m,n) is "+ temp[m][n] );
    }
}   

/*
run:
minimum cost to reach at (m,n) is17
BUILD SUCCESSFUL (total time: 0 seconds)

*/
