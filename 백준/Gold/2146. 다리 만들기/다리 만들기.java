import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int[][] visited;
	static int n,cnt=1,result=Integer.MAX_VALUE;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph=new int[n][n];
		visited=new int[n][n];
		for(int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(graph[i][j]==1 && visited[i][j]==0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(graph[i][j]!=0) {
					visited=new int[n][n];
					search(i,j,graph[i][j]);
				}
			}
		}
		System.out.println(result);
	}
	static void search(int x,int y,int number) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y]=1;
		while(!q.isEmpty()) {
			int num[]=q.poll();
			x=num[0];
			y=num[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				
				else if(graph[nx][ny]!=number && graph[nx][ny]!=0) {
					result=Math.min(result,visited[x][y]-1);
					return;
				}
				if(graph[nx][ny]==0 && visited[nx][ny]==0) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=visited[x][y]+1;
				}
			}
		}
	}
	
	static void bfs(int x,int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y]=1;
		graph[x][y]=cnt;
		while(!q.isEmpty()) {
			int num[]=q.poll();
			x=num[0];
			y=num[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && graph[nx][ny]==1 && visited[nx][ny]==0) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=1;
					graph[nx][ny]=cnt;
				}
			}
		}
	}
}
