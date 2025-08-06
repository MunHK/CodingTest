import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int wy,hx;
	static Queue<int[]> q;
	static int[] dx= {-1,-1,-1,0,0,1,1,1};
	static int[] dy= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			wy=Integer.parseInt(st.nextToken());
			hx=Integer.parseInt(st.nextToken());
			int result=0;
			if(wy==0 & hx==0) {
				break;
			}
			q = new LinkedList<>();
			graph=new int[hx][wy];
			for(int i=0;i<hx;i++) {
				String[] in = br.readLine().split(" ");
				for(int j=0;j<wy;j++) {
					graph[i][j]=Integer.parseInt(in[j]);
				}
			}
			for(int i=0;i<hx;i++) {
				for(int j=0;j<wy;j++) {
					if(graph[i][j]==1) {
						bfs(i,j);
						result+=1;
					}
				}
			}
			System.out.println(result);
		}
	}
	public static void bfs(int x,int y) {
		q.add(new int[] {x,y});
		graph[x][y]=0;
		while(!q.isEmpty()) {
			int[] in=q.poll();
			x=in[0];
			y=in[1];
			for(int i=0;i<8;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<hx && ny>=0 && ny<wy && graph[nx][ny]==1) {
					q.add(new int[] {nx,ny});
					graph[nx][ny]=0;
				}
			}
		}
	}
}
