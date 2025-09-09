import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int dp[];
	static int in[];
	static int n,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			result=0;
			dp=new int[n];
			in=new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) 
				in[i]=Integer.parseInt(st.nextToken());
			
			for(int i=n-1;i>=0;i--) {
				for(int j=i+1;j<n;j++) {
					if(in[i]<in[j]) {
						dp[i]=Math.max(dp[i], dp[j]+1);
					}
				}
				result=Math.max(result, dp[i]);
			}
			System.out.println("#"+t+" "+(result+1));
		}
	}
}
