import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,out=Integer.MAX_VALUE;
	static int house[][];
	static int dp[][];
	static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		house=new int[n+1][4];
		dp=new int[n+1][4];
		result = new int[4];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				house[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				if(i==j) dp[1][j]=house[1][j];
				else dp[1][j]=1001;
			}
			
			for(int k=2;k<=n;k++) {
				dp[k][1]=Integer.min(dp[k-1][2], dp[k-1][3])+house[k][1];
				dp[k][2]=Integer.min(dp[k-1][1], dp[k-1][3])+house[k][2];
				dp[k][3]=Integer.min(dp[k-1][2], dp[k-1][1])+house[k][3];
				if(k==n) {
					if(i==1) {
						result[i]=Integer.min(dp[n][2], dp[n][3]);
					}
					if(i==2) {
						result[i]=Integer.min(dp[n][1], dp[n][3]);
					}
					if(i==3) {
						result[i]=Integer.min(dp[n][2], dp[n][1]);
					}
				}
			}
		}
		for(int i=1;i<=3;i++) {
			out=Integer.min(out, result[i]);
		}
		System.out.println(out);
	}
}
