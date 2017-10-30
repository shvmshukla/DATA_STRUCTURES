#include <stdio.h>
#include <stdlib.h>
int max(int a,int b);
int max(int a,int b)
{
	return (a>b)? a:b;
}
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	char t1[n],t2[m];
	scanf("%s", t1);
	scanf("%s", t2);
//	n=strlen(t1);
//	m=strlen(t2);
	int table[n+1][m+1];
	
	for(int i=0;i<n+1;i++)
	{
		for(int j=0;j<m+1;j++)
		{
			if(i==0 || j==0)
				table[i][j]=0;
			else if(t1[i-1]==t2[j-1])
				table[i][j]=1+table[i-1][j-1];
			else
				table[i][j]=max(table[i][j-1],table[i-1][j]);
		}
	}
	printf("%d\n",table[n][m]);

	return 0;
}
