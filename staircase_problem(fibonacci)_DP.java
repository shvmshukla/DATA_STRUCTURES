/*
https://www.youtube.com/watch?v=CFQk7OQO_xM&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=33
*/

public class staircase_problem_DP {
    public static void main(String[] args) {
        
    
    int n=5;  //n represents the stair at which you want to go
    int n1=0,n2=1; //initiation
    int sum=0;
     if (n == n1 || n == n2) {
            System.out.println(n);
            return;
        }
    for(int i=1;i<=n;i++)
    {
      sum=n1+n2;
      n1=n2;
      n2=sum;
    }
        System.out.println(n2); 
  } 
}

/*
run:
8
BUILD SUCCESSFUL (total time: 0 seconds)

*/
