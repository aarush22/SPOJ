import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;
class prime1
{
public static void main(String args [])	throws IOException
{
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw=new PrintWriter(System.out, true);
	ArrayList<Integer> primes=new ArrayList<Integer>();
	int upperBound=(int)Math.sqrt(1000000000);int inc=0;
	int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
	boolean[] isComposite = new boolean[upperBound + 1];
	for (int m = 2; m <= upperBoundSquareRoot; m++)
	{
		if (!isComposite[m])
		{
			for (int k = m * m; k <= upperBound; k += m)
			{isComposite[k] = true;}
		}
	}
	for (int m = 2; m <= upperBound; m++)
	{
		if (!isComposite[m])
		{primes.add(m);}
	}
	int t=Integer.parseInt(in.readLine());
	while(t-->0)
	{
		String inp[]=in.readLine().split(" ");
		int a=Integer.parseInt(inp[0]);
		int b=Integer.parseInt(inp[1]);
		int ar[]=new int[b-a+1];
		int limit=(int)Math.sqrt(b);
		if(a==1)ar[0]=1;
		if(a==0)ar[1]=1;
		Iterator it = primes.iterator();
		int st=(int)it.next();
		while(st<=limit)
		{
			int mul=a/st;
			mul*=st;
			while(mul<=b)
			{
				int hold=mul-a;
				if(hold>=0)
				{ar[hold]=1;}
				mul+=st;
			}
			if(st-a>=0)ar[st-a]=0;
			if(!it.hasNext())break;
			st=(int)it.next();
		}
		for(int i=0; i<ar.length; i++)
		{
			if(ar[i]==0)pw.println(i+a);
		}
	}
}
}
