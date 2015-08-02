import java.util.*;
import java.math.*;
import java.io.*;
class pour1
{
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out, true);
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			int a=Integer.parseInt(in.readLine());
			int b=Integer.parseInt(in.readLine());
			int c=Integer.parseInt(in.readLine());
			int n=gcd(a,b);
			int low=a<=b?a:b;int hi=a>=b?a:b;
			if(c>a && c>b)
			{pw.println(-1);}
			else if(c%n!=0)
			{pw.println(-1);}
			else
			{
					pw.println(Math.min(steps(a,b,c),steps(b,a,c)));
			}
		}
	}
	 //return array [d, a, b] such that d = gcd(p, q), ap + bq = d
  /* public static int[] gcd1(int p, int q) 
   {
      if (q == 0)
         return new int[] { p, 1, 0 };

      int[] vals = gcd1(q, p % q);
      int d = vals[0];
      int a = vals[2];
      int b = vals[1] - (p / q) * vals[2];
      return new int[] { d, a, b };
   }*/
	public static int gcd(int p, int q) 
		{
		if (q == 0) return p;
		else return gcd(q, p % q);
		}

	public static int steps(int a, int b, int c)
	{
		int x=a, y=0;int st=1,aux=0;
		while((x!=c && y!=c) )
		{
			if(x<=0)
			{x=a;st+=1;}
			if(y>=b)
			{y=0;st+=1;}
			aux=Math.min(x,b-y);
			st+=1;
			y+=aux;
			x=x-aux;
			
			//System.out.println(st+" "+x+" "+y+"G");
		}
		return st;
	}
	}	
