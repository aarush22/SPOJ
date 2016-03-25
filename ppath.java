import java.util.*;
import java.math.*;
import java.io.*;
class ppath
{
	static boolean[] isComposite;
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out, true);
		int upperBound=10000;
		LinkedList <Integer> primes=new <Integer> LinkedList(); 
		//double st=System.currentTimeMillis();
		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		isComposite = new boolean[upperBound + 1];
		for (int m = 2; m <= upperBoundSquareRoot; m++)
		{
			if (!isComposite[m])
			{
				for (int k = m * m; k <= upperBound; k += m)
				{isComposite[k] = true;}
			}
		}
		/*for (int m = 1000; m <= upperBound; m++)
		{
			if (!isComposite[m])
			{primes.add(m);}
		}*/
		
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			globe=0;
			int visited[]=new int[10000];
			String inp[]=in.readLine().split(" ");
			int source=Integer.parseInt(inp[0]);
			dest=Integer.parseInt(inp[1]);
			visited[source]=1;
			//int a=find(source,0,visited,0);
			//int b=find(source,1,visited,0);
			//int c=find(source,2,visited,0);
			//int d=find(source,3,visited,0);
			if(source==dest)
			{
				pw.println(0);
			}
			else
			{
				pw.println(bfs(source,dest));	
			}
		}
	}
	static int globe=0;
	static int dest=0;
	
	public static int bfs(int source, int dest)
	{
		ArrayList <Integer>qu = new ArrayList<Integer>();
		HashMap <Integer,Integer> set=new HashMap<Integer,Integer>();
		qu.add(source);
		set.put(source,0);
		int steps=0;
		while(!qu.isEmpty())
		{
			int ele=qu.get(0);
			qu.remove(0);
			steps=set.get(ele);
			int rem=ele,temp=0;
			for(int i=0;i<=3; i++)
			{
				for(int j=0; j<=9; j++)
				{
					if((i==0 && j%2==0) || (i==3 && j==0))
					{
					}
					else
					{	
						temp=giveNum(rem,i);
						rem=temp;
						//System.out.println(temp+" "+isComposite[temp]+" "+set.contains(temp));
						if(!isComposite[temp] && !set.containsKey(temp))
						{
							set.put(temp,steps+1);
							if(temp==dest)return steps+1;
							else qu.add(temp);			
						}
					}
				}
			}
		}
		return -1;
	}
	public static int find(int source, int n, int ar[], int steps)
	{
		int num=giveNum(source, n);
		int lim=9,bol=1;
		while(isComposite[num])
		{
			num=giveNum(num,n);
			if(num==source)
			{bol=0;break;}
		}
		//int num=giveNum(source, n);
		
		if(bol==0 || ar[num]==1 || globe==1)return -1;
		//if(isComposite[num]==true)return -1;
		System.out.println(num+" "+steps);
		int back=0;
		if(num==dest)
		{globe=1;return steps;}
		int chk[]=new int[4];
		ar[num]	=1;
		chk[0]=find(num,0,ar,steps+1);
		chk[1]=find(num,1,ar,steps+1);
		chk[2]=find(num,2,ar,steps+1);
		chk[3]=find(num,3,ar,steps+1);
		int min=Integer.MAX_VALUE;
		int cm=min;
		for(int i=0; i<4; i++)
		{
			if(chk[i]>=0 && chk[i]<min)
			{min=chk[i];}
		}
		min=cm==min?-1:min;
		return min;
	}
	public static int giveNum(int source,int n)
	{
		int len=4;
		int ar[]=new int[len];
		int cp=source;
		for(int i=0; i<len; i++)
		{
			ar[i]=cp%10;
			cp/=10;
		}
		ar[n]=(ar[n]+1)%10;
		if(n==0)
		{
			ar[n]=ar[n]%2==0?ar[n]+1:ar[n];
		}
		else if(n==3)
		{
			ar[n]=ar[n]==0?1:ar[n];
		}
		//int p=(int)Math.pow(10,3);
		int ans=0;int p=1;
		for(int j=0; j<len; j++)
		{
			ans=ans+(ar[j]*p);
			p*=10;
		}
		//System.out.println(source+" "+ans+" "+n);
		return ans;
	}
}
