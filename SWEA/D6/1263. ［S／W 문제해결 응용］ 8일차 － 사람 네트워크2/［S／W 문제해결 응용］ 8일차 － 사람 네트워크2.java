import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] dist;
	static int INF=1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			dist=new int[n][n];
			int result=INF;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dist[i][j]=Integer.parseInt(st.nextToken());
					if(dist[i][j]==0 && i!=j)
						dist[i][j]=INF;
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				int sum=0;
				for(int j=0;j<n;j++)
					sum+=dist[i][j];
				result=Math.min(result, sum);
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
