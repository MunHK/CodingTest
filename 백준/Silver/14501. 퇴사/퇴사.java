import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result=0;
		List<TP> list = new ArrayList<>();
		int[] dp=new int[n+1];
		
		for(int i=0;i<n;i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			list.add(new TP(a,b));
		}
		
		for(int i=1;i<=n;i++) {
			TP tp = list.get(i-1);
			if((tp.t+i-1)<=n) {
				dp[tp.t+i-1]=Math.max(dp[tp.t+i-1],dp[i-1]+tp.p);
			}
			dp[i]=Math.max(dp[i],dp[i-1]);
			result=Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}

class TP{
	int t,p;
	TP(int t,int p){
		this.t=t;
		this.p=p;
	}
}