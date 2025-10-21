import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int coin[];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coin=new int[n+1];
		dp=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++) 
			coin[i]=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			int cnow = coin[i];
			dp[i][0]=1;
			for(int j=1;j<=k;j++) {
				if(j<cnow)
					dp[i][j]=dp[i-1][j];
				else 
					dp[i][j]=dp[i][j-cnow]+dp[i-1][j];
			}
		}
		System.out.println(dp[n][k]);
	}
}