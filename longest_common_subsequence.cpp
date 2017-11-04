//longest common subsequence with backtracking as well

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int max(int a,int b);
int max(int a,int b)
{
	return (a>b)? a:b;
}
int main()
{
	int n,m,i,j;
	scanf("%d%d",&n,&m);
	char t1[n],t2[m];
	scanf("%s", t1);
	scanf("%s", t2);
	int table[n+1][m+1];
	
	for(i=0;i<n+1;i++)
	{
		for(j=0;j<m+1;j++)
		{
			if(i==0 || j==0)
				table[i][j]=0;
			else if(t1[i-1]==t2[j-1])
				table[i][j]=1+table[i-1][j-1];
			else
				table[i][j]=max(table[i][j-1],table[i-1][j]);
		}
	}
	for(i=0;i<n+1;i++)
	{
		for(j=0;j<m+1;j++)
		{
			printf("%d\t",table[i][j]);
		}
		printf("\n");
	}
	printf("%d\n",table[n][m] );
	i=n;
	j=m;
	int p=0;
	char res[n>m?m+1:n+1];
	while(i>0&& j>0)
	{
		if(t1[i-1]==t2[j-1])
		{
			res[p++]=t1[i-1];
			i--;
			j--;
		}
		else
		{
			if(table[i-1][j]>table[i][j-1])
				i--;
			else 
				j--;
		}
	}
	res[p]='\0';
	printf("Longest Common Subsequence = ");
	while(p)
	{
		printf("%c",res[--p] );
	}
	printf("\n");
	return 0;
}
