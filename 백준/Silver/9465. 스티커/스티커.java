import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sang[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n=Integer.parseInt(br.readLine());
			sang=new int[2][n];
			dp=new int[n][3];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					sang[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0]=0;
			dp[0][1]=sang[0][0];
			dp[0][2]=sang[1][0];
			for(int i=1;i<n;i++) {
				dp[i][0]=Integer.max(Integer.max(dp[i-1][1], dp[i-1][2]),dp[i-1][0]);
				dp[i][1]=sang[0][i]+Integer.max(dp[i-1][2],dp[i-1][0]);
				dp[i][2]=sang[1][i]+Integer.max(dp[i-1][1],dp[i-1][0]);
			}
			System.out.println(Integer.max(Integer.max(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
			
		}
		
		
		
	}
}
