import java.util.*;
import java.math.*;
import java.io.*;
class herding
{
	static int n;
	static int m;
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out, true);
		String inp[]=in.readLine().split(" ");
		n=Integer.parseInt(inp[0]);
		m=Integer.parseInt(inp[1]);
		ar=new String[n][m];
		for(int i=0; i<n; i++)
		{
			String line[]=in.readLine().split("");
			for(int j=0; j<m; j++)
			{
				ar[i][j]=(line[j]);
			}
		}
		chk=new int[n][m];
		int count=0;
		for(int i1=0; i1<n; i1++)
		{
			for(int j1=0; j1<m; j1++)
			{
				if(chk[i1][j1]==0)
				{
					mark(i1,j1);
					count+=1;
					pw.println(i1+" "+j1);
				}
			}
		}
		pw.println(count);
	}
	
	static int chk[][];
	static String ar[][];
	public static void mark(int x, int y)
	{
		if(chk[x][y]==1)return;
		chk[x][y]=1;
		if(x>0)
		{
			
			if(ar[x-1][y].equals("S"))
			{
				//chk[x-1][y]=1;
				mark(x-1,y);
				
			}
		}
		if(x<n-1)
		{
			
			if(ar[x+1][y].equals("N"))
			{
			//chk[x+1][y]=1;	
				mark(x+1,y);
			}
		}
		if(y>0)
		{
			
			if(ar[x][y-1].equals("E"))
			{
				//chk[x][y-1]=1;
				mark(x,y-1);
			}
		}
		if(y<n-1)
		{
			
			if(ar[x][y+1].equals("W"))
			{
				//chk[x][y+1]=1;
				mark(x,y+1);
			}
		}
	}
}
