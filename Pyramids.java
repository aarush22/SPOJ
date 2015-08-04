import java.util.*;
import static java.lang.Math.sqrt;
import java.io.*;
class Pyramids
{
	public static void main(String args [])	throws IOException
	{
		//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out, true);
		//int t=Integer.parseInt(in.readLine());
		int t=sc.nextInt();
		while(t-->0)
		{
		//String inp[]=in.readLine().split(" ");
		double X=0,Y=0,Z=0,x=0,y=0,z=0;
		double U=sc.nextDouble();		//u
		double V=sc.nextDouble();		//v
		double w=sc.nextDouble();		//w
		double W=sc.nextDouble();		//W
		double v=sc.nextDouble();		//V
		double u=sc.nextDouble();		//U
		X=(w-U+v)*(U+v+w); x=(U-v+w)*(v-w+U);Y=(u-V+w)*(V+w+u);
        y=(V-w+u)*(w-u+V); Z=(v-W+u)*(W+u+v);z=(W-u+v)*(u-v+W);
        double a=sqrt(x*Y*Z);
        double b=sqrt(y*Z*X);
        double c=sqrt(z*X*Y);
        double d=sqrt(x*y*z);
        double vol=((-a+b+c+d)*(a-b+c+d)*(a+b-c+d)*(a+b+c-d));
		vol=Math.sqrt(vol)/(192*u*v*w);
		pw.println(String.format("%.4f",vol));
		//pw.println(vol);	
		}
	}
}
		
		
