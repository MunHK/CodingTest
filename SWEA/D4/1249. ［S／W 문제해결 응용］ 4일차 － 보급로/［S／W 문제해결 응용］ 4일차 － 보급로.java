import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int graph[][];
	static int visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			graph=new int[n][n];
			visited=new int[n][n];
			for(int i=0;i<n;i++) {
				String[] in = br.readLine().split("");
				Arrays.fill(visited[i], Integer.MAX_VALUE);
				for(int j=0;j<n;j++) {
					graph[i][j]=Integer.parseInt(in[j]);
				}
			}
			bfs();
			System.out.println("#"+tc+" "+visited[n-1][n-1]);
			
		}
	}
	static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0,0,0));
		visited[0][0]=0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.x==n-1 && now.y==n-1) {
				break;
			}
			for(int i=0;i<4;i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]>graph[nx][ny]+now.w) {
					visited[nx][ny]=graph[nx][ny]+now.w;
					q.add(new Node(nx,ny,visited[nx][ny]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int x,y,w;
	Node(int x,int y,int w){
		this.x=x;
		this.y=y;
		this.w=w;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.w, o.w);
	}
	
}