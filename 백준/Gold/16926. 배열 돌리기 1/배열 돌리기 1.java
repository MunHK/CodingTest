import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m,r;
	static int graph[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<r;i++)
			rotate();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void rotate() {
		for(int cnt=0;cnt<Math.min(n, m)/2;cnt++) {//4 3 4 2  -> 2 1 2 0
			int start = graph[cnt][cnt];
			for(int i=cnt;i<m-1-cnt;i++) {
				graph[cnt][i]=graph[cnt][i+1];
			}
			for(int i=cnt;i<n-1-cnt;i++) {
				graph[i][m-1-cnt]=graph[i+1][m-1-cnt];
			}
			for(int i=m-1-cnt;i>cnt;i--) {
				graph[n-1-cnt][i]=graph[n-1-cnt][i-1];
			}
			for(int i=n-1-cnt;i>cnt;i--) {
				graph[i][cnt]=graph[i-1][cnt];
			}
			graph[1+cnt][cnt]=start;
		}
	}
}
