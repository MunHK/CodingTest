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
	static int mx,start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			start=0; mx=0;
			N=Integer.parseInt(br.readLine());
			graph=new int[N][N];
			visited=new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j]==0)
						bfs(i,j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(mx<visited[i][j]) {
						start=graph[i][j];
						mx=visited[i][j];
					}
					else if(mx==visited[i][j] && graph[i][j]<start) {
						start=graph[i][j];
						mx=visited[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+start+" "+mx);
		}
	}
	public static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		int cnt=0;
		q.add(new int[] {x,y});
		visited[x][y]=1;
		while(!q.isEmpty()) {
			int[] num=q.poll();
			x=num[0];
			y=num[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && graph[x][y]-1==graph[nx][ny]) {
					cnt+=1;
					visited[nx][ny]=visited[x][y]+1;
					q.add(new int[] {nx,ny});
					
				}
			}
		}
		if(cnt==0)
			visited[x][y]=0;
	}

}