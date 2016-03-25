import java.util.*;
import java.math.*;
import java.io.*;
class herding
{
	static int n;
	static int m;
	static int count=0;
	static int constant=1;
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
		count=0;
		for(int i1=0; i1<n; i1++)
		{
			for(int j1=0; j1<m; j1++)
			{
				if(chk[i1][j1]==0)
				{
					markIn(i1,j1);
					chk[i1][j1]=0;
					markOut(i1,j1);
					count+=1;
					pw.println(i1+" "+j1+"    "+count);
					print(chk);
					constant++;
				}
			}
		}
		pw.println(count);
	}
	
	static int chk[][];
	static String ar[][];
	public static void print(int ar[][] )
	{
		for (int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void markIn(int x, int y)
	{
		if(chk[x][y]!=0)
		{
			if(chk[x][y]==constant)	return;
			else 
			{
				count-=1;
				return;
			}
		}
		chk[x][y]=constant;
		if(x>0)
		{
			if(ar[x-1][y].equals("S"))
			{
				//chk[x-1][y]=1;
				markIn(x-1,y);
				
			}
		}
		if(x<n-1)
		{
			
			if(ar[x+1][y].equals("N"))
			{
			//chk[x+1][y]=1;	
				markIn(x+1,y);
			}
		}
		if(y>0)
		{
			
			if(ar[x][y-1].equals("E"))
			{
				//chk[x][y-1]=1;
				markIn(x,y-1);
			}
		}
		if(y<m-1)
		{
			
			if(ar[x][y+1].equals("W"))
			{
				//chk[x][y+1]=1;
				markIn(x,y+1);
			}
		}
	}
	public static void markOut(int x, int y)
	{
		if(chk[x][y]!=0)
		{
			if(chk[x][y]==constant)	return;
			else 
			{
				count-=1;
				return;
			}
		}
		chk[x][y]=constant;
		if(ar[x][y].equals("N"))
		{
			x-=1;
			if(x>=0)markOut(x,y);
		}
		else if(ar[x][y].equals("S"))
		{
			x+=1;
			if(x<n)markOut(x,y);
		}
		else if(ar[x][y].equals("W"))
		{
			y-=1;
			if(y>=0)markOut(x,y);
		}
		else
		{
			y+=1;
			if(y<m)markOut(x,y);
		}
	}
}
