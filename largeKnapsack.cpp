#include <iostream>
using namespace std;

int knapsackDP(int W, int wt[], int val[], int N)				//DP- knapsack solution
{
	int dp[W+1];
	try
	{
		for (int fill=0; fill<=W; fill++)
			dp[fill]=0;
		for(int i=1; i<=N; i++)
		{
			for(int j=W; j>=wt[i-1]; j--)
			{
				dp[j]=max(val[i-1]+dp[j-wt[i-1]],dp[j]);
			}
		}
	}
	catch(int e)
	{
		cout<<"exception"<<endl;
	}
	return dp[W];
}	

 
int main()
{
	int W=0,N=0;
	ios::sync_with_stdio(false);
	cin >> W;
	cin >> N;
	int wt[N];
	int val[N];
	for(int i=0; i<N; i++)
	{
		cin >> val[i];
		cin >> wt[i];
	}
	int ans=knapsackDP(W,wt,val,N);
	cout << ans << endl;
	return 0;
}
