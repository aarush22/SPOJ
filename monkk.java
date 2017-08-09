	import java.util.*;
	import java.math.*;
	import java.io.*;
	class monkk
	{
		static int n=0;static int m=0;
		public static void main(String args [])	throws IOException
		{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw=new PrintWriter(System.out, true);
			int t=Integer.parseInt(in.readLine());
			String useless=in.readLine();
			while(t-->0)
			{
				String str[]=in.readLine().split(" ");
				 n=Integer.parseInt(str[0]);
				m=Integer.parseInt(str[1]);
				char ar[][]=new char[n][m];
				for(int i=0; i<n; i++)
				{
					String str1=in.readLine();
					for(int j=0; j<m; j++)
					{
						ar[i][j]=str1.charAt(j);
					}
				}
				int calc[][]=new int[n][m];
				if(ar[0][0]!='T')calc[0][0]+=1;
				for(int i1=1; i1<m; i1++)
				{
					if(ar[0][i1]!='T')calc[0][i1]+=1;
				}
				for(int i2=1; i2<n; i2++)
				{
					if(ar[i2][0	]!='T')calc[i2][0]+=1;
				}
				int max=0;
				for(int r=1; r<n; r++)
				{
					for(int c=1; c<m; c++)
					{
						if(ar[r][c]!='T')
						{
							//if(calc[r-1][c]==calc[r][c-1] && calc[r][c-1]>0)calc[r][c]=1+calc[r-1][c];
							//else calc[r][c]=Math.max(calc[r-1][c],calc[r][c-1]);
							//if(calc[r][c]==0 && (ar[r-1][c]=='B' || ar[r][c-1]=='B'))calc[r][c]+=1;
							//if(calc[r-1][c-1]==0)calc[r][c]-=1;
							calc[r][c]=Math.min(Math.min(calc[r][c-1],calc[r-1][c]),calc[r-1][c-1])+1;
							
						}
						max=max>calc[r][c]?max:calc[r][c];
					}
				}
				print (calc);
				pw.println("Case "+num+": "+max*max);
				num++;
				useless=in.readLine();
			}
		}
		static int num=1;
		public static void print(int ar[][])
		{
				for(int r=0; r<n; r++)
				{
					for(int c=0; c<m; c++)
					{
						System.out.print(ar[r][c]);
					}
					System.out.println();
				}
		} 
	}

