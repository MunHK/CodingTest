import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int map[][];
	static int visited[][];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		visited=new int[n][m];
		for(int i=0;i<n;i++) {
			String[] in = br.readLine().split("");
			Arrays.fill(visited[i], Integer.MAX_VALUE);
			
			for(int j=0;j<m;j++)
				map[i][j]=Integer.parseInt(in[j]);
		}
		
		dij();
		System.out.println(visited[n-1][m-1]);
	}
	private static void dij() {
		PriorityQueue<Algo> pq = new PriorityQueue<>();
		visited[0][0]=0;
		pq.add(new Algo(0,0,0));
		while(!pq.isEmpty()) {
			Algo algo = pq.poll();
			if(algo.x==n-1 && algo.y==m-1)
				break;
			for(int i=0;i<4;i++) {
				int nx=algo.x+dx[i];
				int ny=algo.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]>algo.cost+map[nx][ny]) {
					pq.add(new Algo(nx,ny,algo.cost+map[nx][ny]));
					visited[nx][ny]=algo.cost+map[nx][ny];
				}
			}
		}
	}
	static class Algo implements Comparable<Algo>{
		int x,y,cost;
		Algo(int x,int y,int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		@Override
		public int compareTo(Algo o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
