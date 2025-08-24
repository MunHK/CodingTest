import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static int n,m;
	static int mx=0,cnt=0;
	static int[] dx = {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		graph=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(mx);
	}
	
	static void bfs(int x,int y) {
		int count=1;
		cnt++;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		graph[x][y]=0;
		while(!q.isEmpty()) {
			int a[]=q.poll();
			x=a[0];
			y=a[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==1) {
					q.add(new int[] {nx,ny});
					graph[nx][ny]=0;
					count++;
				}
			}
		}
		mx=Math.max(mx, count);
	}
}