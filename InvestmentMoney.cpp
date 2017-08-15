#include <iostream>
using namespace std;

int knapsackDP(int W, int wt[], int val[], int N)				//DP- knapsack solution
{
	int dp[W+1];
	try
	{
		for (int fill=0; fill<=W; fill++)
			dp[fill]=0;
		for(int i=0; i<=W; i++)
		{
			for(int j=0; j<N; j++)
			{
				if (wt[j]<=i)
					dp[i]=max(val[j]+dp[i-wt[j]],dp[i]);	//check each element max value for their weight again and again
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
	int W=0,N=0,i=0,t=0,b=0;
	cin >> t;
	while(t-->0)
	{
		cin >> W;
		cin >> b;
		cin >> N;
		int wt[N];
		int val[N];
		for(i=0; i<N; i++)
		{
			cin >> wt[i];
			cin >> val[i];
			wt[i]/=1000;
		}
		int ans=0;
		int rem=W%1000;
		W/=1000;
		while(b-->0)
		{
			//ans=knapsack(W,wt,val,N,0);
			ans=knapsackDP(W,wt,val,N);
			W=(W*1000)+rem+ans;
			rem=W%1000;
			W/=1000;
			//cout << ans << endl;
		}
		W=(W*1000)+rem;
		cout << W << endl;
	}
	return 0;
}
