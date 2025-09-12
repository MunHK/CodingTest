import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] dist;
	static int INF=1000000000;
	static int mn=Integer.MAX_VALUE,result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		dist=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i]=0;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			dist[a][b]=1;
			dist[b][a]=1;
		}
		for(int k=0;k<n;k++) {
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
			
			if(sum<mn) {
				mn=sum;
				result=i+1;
			}
		}
		System.out.println(result);
	}
}
