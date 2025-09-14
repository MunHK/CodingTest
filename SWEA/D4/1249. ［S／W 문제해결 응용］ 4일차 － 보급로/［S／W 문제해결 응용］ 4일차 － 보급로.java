import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static int[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			visited=new int[n][n];
			
			for(int i=0;i<n;i++) {
				String[] in=br.readLine().split("");
				Arrays.fill(visited[i], Integer.MAX_VALUE);
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(in[j]);
				}
			}
			bfs();
			System.out.println("#"+tc+" "+visited[n-1][n-1]);
			
		}
	}
	static void bfs() {
		PriorityQueue<Sol> pq = new PriorityQueue<>();
		pq.add(new Sol(0,0,0));
		visited[0][0]=0;
		while(!pq.isEmpty()) {
			Sol sol=pq.poll();
			if(sol.x==n-1 && sol.y==n-1)
				break;
			for(int i=0;i<4;i++) {
				int nx=sol.x+dx[i];
				int ny=sol.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]>sol.cost+map[nx][ny]) {
					visited[nx][ny]=sol.cost+map[nx][ny];
					pq.add(new Sol(nx,ny,visited[nx][ny]));
				}
					
			}
		}
	}
	static class Sol implements Comparable<Sol>{
		int x,y,cost;
		Sol(int x,int y,int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		@Override
		public int compareTo(Sol o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}
}
