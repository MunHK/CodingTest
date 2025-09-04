import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int dp[];
	static List<CS> list;
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		dp=new int[n+1];
		list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new CS(a,b));
		}
		for(int i=1;i<=n;i++) {
			CS cs = list.get(i-1);
			if(i+cs.t-1<=n)
				dp[cs.t+i-1]=Math.max(dp[cs.t+i-1], dp[i-1]+cs.p);
			dp[i]=Math.max(dp[i],dp[i-1]);
			result=Math.max(dp[i], result);
		}
		System.out.println(result);
	}
	static class CS{
		int t,p;
		CS(int t,int p){
			this.t=t;
			this.p=p;
		}
	}
}
