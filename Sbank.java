import java.util.*;
import static java.lang.Math.sqrt;
import java.io.*;
class Sbank
{
	public static void main(String args [])	throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out, true);
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			int n=Integer.parseInt(in.readLine());
			Map<String,Integer> map=new HashMap<String,Integer>();
			List <String> inp=new ArrayList<String>();
			String hold="";int inc=0;
			for(int i=0; i<n; i++)
			{
				hold=in.readLine();
				if(map.containsKey(hold))
				{
					int pt=(int)map.get(hold);
					pt+=1;
					map.put(hold,pt);
				}
				else
				{
					map.put(hold,1);
					inp.add(hold);
				}
			}
			Collections.sort(inp);
			for(int j=0; j<inp.size(); j++)
			{
				hold=inp.get(j);
				int p=map.get(hold);
				pw.println(hold+" "+p);
			}
			String useless=in.readLine();
			pw.println();
		}
	}
}
