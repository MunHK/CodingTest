import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] graph;
	static boolean[][] visited;
	static int N,L,R;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static Queue<int[]> dis = new LinkedList<>();
	static boolean bmove=false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int result=0;
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		graph=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			bmove=false;
			visited=new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			if(!bmove)
				break;
			result+=1;
		}
		
		System.out.println(result);
		
	}
	static void bfs(int startx,int starty) {
		int total=graph[startx][starty],n=1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startx,starty});
		visited[startx][starty]=true;
		dis.add(new int[] {startx,starty});
		while(!q.isEmpty()) {
			int[] d = q.poll();
			int x=d[0];
			int y=d[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && 
						Math.abs(graph[x][y]-graph[nx][ny])>=L && Math.abs(graph[x][y]-graph[nx][ny])<=R) {
					dis.add(new int[] {nx,ny});
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
					total+=graph[nx][ny];
					n+=1;
				}
			}
		}
		if(dis.size()>1) {
			bmove=true;
			move(total,n);
		}
		else {
			dis.poll();
		}
	}
	static void move(int total,int n) {
		int di = total/n;
		while(!dis.isEmpty()) {
			int[] d=dis.poll();
			graph[d[0]][d[1]]=di;
		}
	}
}