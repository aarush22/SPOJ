import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.*;
class Factorial
{
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out, true);
		//List<Integer> pl=new ArrayList<Integer>();
		//pl= generatePrimes(1000000000);
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(in.readLine());
			int ans=1,inc=1,sum=0;
			while((ans>=1))
			{
				ans=(int)n/(int)Math.pow(24,inc++);
				sum+=ans;
				//pw.println(sum+" "+ans);
			}
			pw.println(sum);
		}
	}
}
