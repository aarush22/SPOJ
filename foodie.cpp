#include <iostream>
using namespace std;


int knapsack(int W, int wt[], int val[], int N,int ind)			//Recursive Knapsack solution
{
	if(ind == N || W <=0)
		return 0;
	if (wt[ind]>W)
		return knapsack(W, wt, val, N, ind+1);
	else
		return max(val[ind]+knapsack(W-wt[ind], wt, val, N, ind+1),knapsack(W, wt, val, N, ind+1));
}

int knapsackDP(int W, int wt[], int val[],int N)				//DP- knapsack solution
{
	int dp[N+1][W+1];
	for(int i=0; i<=N; i++)
	{
		for(int j=0; j<=W; j++)
		{
			if(i == 0 || W == 0)
				dp[i][j] = 0;
			else if (wt[i-1]>j)
				dp[i][j]=dp[i-1][j];
			else
				dp[i][j]=max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
		}
	}
	return dp[N][W];
}

 
int main()
{
	int t=0;
	cin >> t;
	while(t-->0)
	{
		int W=0,N=0,v=0,i=0,temp=0, inp=0;
		cin >> W;
		cin >> N;
		int wt[N];
		int val[N];
		for(i=0; i<N; i++)
		{
			cin >> temp;
			for(int j=0; j<temp; j++)
			{
				cin >> v;
				inp+=v;
			}
			val[i]=inp;
			wt[i]=inp;
		}
		int ans=knapsackDP(W,wt,val,N);
		cout << ans << endl;
	}
	return 0;
}
