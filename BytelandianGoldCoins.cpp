#include <iostream>
using namespace std;

long long dp[100000];

long long recSol(long long n)
{
	if (n==1)
		return 1;
	else if (n==0)
		return 0;
	else
		if (n<100000)
		{
			if(dp[n/2]==-1)
				dp[n/2]=recSol(n/2);
			if(dp[n/3]==-1)
				dp[n/3]=recSol(n/3);
			if(dp[n/4]==-1)
				dp[n/4]=recSol(n/4);
			return max(n,dp[n/2]+dp[n/3]+dp[n/4]);
		}
		else
		{
			return max(n,recSol(n/2)+recSol(n/3)+recSol(n/4));
		}
}	

int main()
{
	long long n;
	for(int i=0; i<100000; i++)
		dp[i]=-1;
	while(cin >> n)
	{
		cout << recSol(n) << endl;
	}
	return 0;
}
