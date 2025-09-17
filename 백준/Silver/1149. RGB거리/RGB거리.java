import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,result=Integer.MAX_VALUE;
	static int home[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		home=new int[n+1][4];
		dp=new int[n+1][4];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				home[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=3;j++) {
					if(i==j) continue;
					dp[k][i]=Math.min(dp[k][i], dp[k-1][j]);
				}
				dp[k][i]+=home[k][i];
				if(k==n)
					result=Math.min(result, dp[k][i]);
			}
		}
		System.out.println(result);
		
	}
}
