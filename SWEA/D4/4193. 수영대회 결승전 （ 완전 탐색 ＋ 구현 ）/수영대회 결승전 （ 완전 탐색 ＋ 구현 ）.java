import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int N;
	static int[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int startx,starty,endx,endy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st;
			graph=new int[N][N];
			visited=new int[N][N];
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					graph[i][j]=Integer.parseInt(st.nextToken());
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			
			st=new StringTokenizer(br.readLine()," ");
			startx=Integer.parseInt(st.nextToken());
			starty=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine()," ");
			endx=Integer.parseInt(st.nextToken());
			endy=Integer.parseInt(st.nextToken());
			
			
			bfs();
			if(visited[endx][endy]==Integer.MAX_VALUE) {
				System.out.println("#"+t+" -1");
			}else
				System.out.println("#"+t+" "+(visited[endx][endy]-1));
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startx,starty});
		visited[startx][starty]=1;
		while(!q.isEmpty()) {
			int[] in=q.poll();
			int x=in[0];
			int y=in[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && graph[nx][ny]!=1) {
					int des;
					if(graph[nx][ny]==2 && (visited[x][y]-1)%3!=2) 
						des=(visited[x][y]+1)+2-(visited[x][y]-1)%3;
					else 
						des=visited[x][y]+1;
					if(des<visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny]=des;
					}
				}
			}
		}
	}
}
