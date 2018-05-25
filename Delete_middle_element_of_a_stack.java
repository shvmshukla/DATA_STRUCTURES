/*
https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
Given a stack with push(), pop(), empty() operations, delete middle of it without using any additional data structure.

Input:
The first line contains an integer T, the number of test cases. For each test case, the first line contains an integer n, denoting the size of the stack. Next line contains n space separated integers that will be pushed into the stack.

Output:
For each test case, the output is the stack with middle element deleted.

Constraints:
1<=T<=100
1<=n<=100

Example:
Input
2
5
1 2 3 4 5
7
1 2 3 4 5 6 7​
Output
5 4 2 1
7 6 5 3 2 1
*/

//User function Template for Java (with an additional datastructure temp)
class GfG{
    public Stack<Integer> deleteMid(Stack<Integer> s,int n,int current){
        //Your code here.
       // int n=s.size();
        Stack<Integer> temp= new Stack<Integer>();
    for(int i=0;i<n/2;i++)
    {
      int a=s.peek();
      temp.add(a);
      s.pop();
    }
    s.pop();
    for(int i=0;i<n/2;i++)
    {
      int b=temp.peek();
      s.add(b);
      temp.pop();
    }
    return s;
  }
}

//Method2: without any additional data structure

//User function Template for Java
class GfG{
    public Stack<Integer> deleteMid(Stack<Integer> s,int n,int current){
        //Your code here.
        int i=0;
        while(i<s.size()/2)
        i++;
        if(s.size()%2==0)
        s.remove(i-1);
        else
        s.remove(i);
        return s;
    }
}
