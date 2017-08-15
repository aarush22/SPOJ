#include <iostream>
#include <string>
#include <stack>
using namespace std;


int priority(char ele)
{
	if (ele=='^')
		return 1;
	else if (ele=='/')
		return 2;
	else if (ele=='*')
		return 3;
	else if (ele=='+')
		return 4;
	else if (ele=='-')
		return 5;
}


int main()
{
	int t;
	stack <char> rpn;
	cin >> t;
	string str,ans;
	while(t-->0)
	{
		ans="";
		cin >> str;
		int len=str.size();
		for(int i=0; i<len; i++)
		{
			char ele=str[i];
			if(ele=='(')
			{
				rpn.push(ele);
			}
			else if(ele==')')
			{
				char ret=rpn.top();
				//cout << ret << endl;
				while(ret!='(')
				{
					ans+=ret;
					if(!rpn.empty())
					{
						rpn.pop();
						ret=rpn.top();
					}
				}
				rpn.pop();
			}
			else if((int)ele>=97 && (int)ele<=122)
			{
				ans+=ele;
			}
			else
			{
				char ret=rpn.top();
				while(ret!=')' && ret!='(' && priority(ret)>=priority(ele) && !rpn.empty())
				{
					ans+=ret;
					if(!rpn.empty())
					{
						rpn.pop();
						ret=rpn.top();
					}	
				}
				rpn.push(ele);
			}
		
		}
		cout << ans << endl;
	}
	return 0;
}
