import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int visited[][][];
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		visited=new int[n][m][2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<2;k++)
					visited[i][j][k]=Integer.MAX_VALUE;
			}
		}
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			String in[]=br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(in[j]);
			}
		}
		
		bfs();
		int result=Integer.min(visited[n-1][m-1][0], visited[n-1][m-1][1]);
		if(result==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result+1);
	}
	static void bfs() {
		Queue<Tank> q = new ArrayDeque<>();
		q.add(new Tank(0,0,0));
		visited[0][0][0]=0;
		visited[0][0][1]=0;
		while(!q.isEmpty()) {
			Tank tank = q.poll();
			for(int i=0;i<4;i++) {
				int nx=tank.x+dx[i];
				int ny=tank.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==1 && tank.broken==0 && visited[nx][ny][tank.broken]>visited[tank.x][tank.y][tank.broken]+1) {
						q.add(new Tank(nx,ny,1));
						visited[nx][ny][1]=visited[tank.x][tank.y][tank.broken]+1;
					}
					if(map[nx][ny]==0 && visited[nx][ny][tank.broken]>visited[tank.x][tank.y][tank.broken]+1) {
						q.add(new Tank(nx,ny,tank.broken));
						visited[nx][ny][tank.broken]=visited[tank.x][tank.y][tank.broken]+1;
					}
				}
			}
		}
		
	}
	static class Tank{
		int x,y,broken;
		Tank(int x,int y,int broken){
			this.x=x;
			this.y=y;
			this.broken=broken;
		}
	}
}
