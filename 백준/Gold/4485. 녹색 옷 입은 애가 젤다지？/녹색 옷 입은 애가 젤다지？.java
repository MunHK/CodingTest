import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Thief implements Comparable<Thief>{
	int x,y,dis;
	Thief(int x,int y,int dis){
		this.x=x;
		this.y=y;
		this.dis=dis;
	}
	@Override
	public int compareTo(Thief o) {
		// TODO Auto-generated method stub
		return this.dis<o.dis ? -1:1;
	}
	
}

public class Main {
	static int[][] graph;
	static int n, tc=0;
	static int[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			tc++;
			n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			graph=new int[n][n];
			visited=new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(visited[i], Integer.MAX_VALUE);
				for (int j = 0; j < n; j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(new Thief(0,0,graph[0][0]));
		}
	}
	
	public static void bfs(Thief thief) {
		Queue<Thief> q = new PriorityQueue<>();
		q.add(thief);
		visited[thief.x][thief.y]=graph[thief.x][thief.y];
		while(!q.isEmpty()) {
			Thief t = q.poll();
			if(t.x==n-1 && t.y==n-1) {
				System.out.println("Problem "+tc+": "+t.dis);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx=t.x+dx[i];
				int ny=t.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && t.dis+graph[nx][ny]<visited[nx][ny]) {
					q.add(new Thief(nx,ny,t.dis+graph[nx][ny]));
					visited[nx][ny]=t.dis+graph[nx][ny];
				}
			}
		}
	}
}
