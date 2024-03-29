package Newton;

import java.util.Map;

public class Newton {
	private static double fx(double x) {
		return 32*Math.pow(x, 6)-48*Math.pow(x, 4)+18*Math.pow(x, 2)-1;
	}
	private static double dfx(double x) {
		return 160*Math.pow(x, 5)-48*4*Math.pow(x, 3)+36*x;
	}
	private static void newton(double a,double e1,double e2, int N) {
		double x=a;
		double x1=0.0;
		double f = 0.0;
		double df = 0.0;
		for(int n=1;n<=N;n++) {
			f = fx(x);
			df = dfx(x);
			if(Math.abs(f)<e1) {
				System.out.println("迭代次数n = "+n+" ,根x*的近似值："+x+" fx："+fx(x));
				return;
			}
			if(Math.abs(df)<e2) {
				System.out.println("|DF|<e2失败！");
				return;
			}
			x1 = x-f/df;
			if(Math.abs(x1-x)<e1) {
				System.out.println("迭代次数n = "+n+" ,根x*的近似值："+x1+" fx："+fx(x1));
				return;
			}
			x=x1;
		}
		System.out.println("失败！");
		return;
	}
	public static void main(String[] args) {
		System.out.println("question 2：(2)");
		int n=6;
		for(int j=0;j<=n;j++) {
			double x = Math.cos((2*j+1)*Math.PI/(2*n+2));
			newton(x, 1e-6, 1e-6, 20);
		}
	}
}
