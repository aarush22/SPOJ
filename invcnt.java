
import java.io.*;
class invcnt
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		String useless=(in.readLine());
		while(t-->0)
		{
			global=0;
			int n=Integer.parseInt(in.readLine());
			int ar[]=new int[n];		
			for(int j=0; j<ar.length; j++)
			{
				ar[j]=Integer.parseInt(in.readLine());
			}
			mSort(ar,0,ar.length-1);
			/*for(int i:ar)
			{
				System.out.print(i+" ");
			}*/
			useless=(in.readLine());
			System.out.println(global);
		}
	}
	public static void mSort(int ar[],int i, int n)
	{
		if(i<n)
		{
		int mid=i+((n-i)/2);
		mSort(ar,i,mid);
		mSort(ar,mid+1,n);
		merger(ar,i,n);
		}
	}
	static long global=0;
	public static void merger(int ar[],int i,int n)
	{
		int st=i;
		int nx=i+((n-i)/2)+1;int inc=0;
		int aux[]=new int[n-i+1];
		while(st<=(i+((n-i)/2)) && nx<=n)
		{
			if(ar[st]>ar[nx])
			{
				//System.out.println(ar[st]+" "+ar[nx]);
				aux[inc]=ar[nx];
				nx+=1;
				global+=(((i+((n-i)/2))-st)+1);
			}
			else
			{
				aux[inc]=ar[st];
				st+=1;
			}
			inc+=1;
		}
		while(st<=(i+((n-i)/2)))
		{
			aux[inc]=ar[st];
			st+=1;inc+=1;
		}
		while(nx<=n)
		{
			aux[inc]=ar[nx];
				nx+=1;
				inc+=1;
		}
		for(int j=0; j<aux.length; j++)
		{
			//System.out.print(aux[j]);
			ar[i]=aux[j];
			i++;
			inc++;
		}
	}
}
