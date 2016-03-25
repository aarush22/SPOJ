import java.util.*;
import java.math.*;
import java.io.*;
class Wachovia
{
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out, true);
		
			String str[]=in.readLine().split(" ");
			int W=Integer.parseInt(str[0]);
			int n=Integer.parseInt(str[1]);
			int val=0,wt=0;
			int max=W;int ans[][]=new int [3][max+1];
			int mar[][]=new int[2] [max+1];
			int last=0,use=0;
			//int small=Integer.MAX_VALUE;
			for(int j=1; j<=n; j++)
			{
				String si[]=in.readLine().split(" ");
				val=Integer.parseInt(si[0]);wt=Integer.parseInt(si[1]);
				int jmt=j%3,jit=(j-1)%3;last=jmt;
				//small=small<wt?small:wt;
				for(int k=wt; k<=max; k++)
				{	
					/*if(wt>k)
					{ans[jmt][k]=ans[jit][k];}
					else*/
					//ans[jmt][k]=Math.max((val+ans[jit][k-wt]),ans[jit][k]);
					if(j%2!=0)
					{//pw.print(mar[0][k]+" "+mar[0][k-wt]+"GF");
					ans[jmt][k]=Math.max((val+mar[0][k-wt]),mar[0][k]);
					mar[1][k]=mar[1][k]>ans[jmt][k]?mar[1][k]:ans[jmt][k];
					
					}
					else
					{
						//pw.print(mar[1][k]+" "+mar[1][k-wt]+"GF");
						ans[jmt][k]=Math.max((val+mar[1][k-wt]),mar[1][k]);
					mar[0][k]=mar[0][k]>ans[jmt][k]?mar[0][k]:ans[jmt][k];
					pw.print(mar[0][k]+" ");
					}
				}
				pw.println();
			}
			System.out.println( ans[last][max]);
		
	
}
}