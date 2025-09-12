import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] dist;
	static int INF = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		dist=new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i]=0;
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			dist[a][b]=Math.min(dist[a][b], c);
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(dist[i][j]==INF)
					System.out.print(0+" ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
}
