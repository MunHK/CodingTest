import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int dist[][];
	static int INF=1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			m=Integer.parseInt(br.readLine());
			dist=new int[n][n];
			int result=0;
			for(int i=0;i<n;i++) {
				Arrays.fill(dist[i], INF);
				dist[i][i]=0;
			}
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken())-1;
				int b=Integer.parseInt(st.nextToken())-1;
				dist[a][b]=1;
			}
			
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(dist[i][j]!=0 && dist[i][j]!=INF && dist[j][i]==INF) {
						dist[j][i]=-1;
					}
				}
			}
			for(int i=0;i<n;i++) {
				boolean know=true;
				for(int j=0;j<n;j++) {
					if(dist[i][j]==INF)
						know=false;
				}
				if(know)
					result+=1;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
