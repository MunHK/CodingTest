import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ice[][];
	static int chice[][];
	static int n,m,icecnt,result=0;
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ice=new int[n][m];
		chice=new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				ice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			icecnt=0;
			for(int i=0;i<n;i++) 
				System.arraycopy(ice[i], 0, chice[i], 0, m);
			
			visited=new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(ice[i][j]!=0 && !visited[i][j]) {
						bfs(i,j);
						icecnt++;
					}
				}
			}
			if(icecnt>=2 || icecnt==0) {
				System.out.println(icecnt==0?0:result);
				break;
			} 
			fuze();
			result++;
		}
	}
	private static void fuze() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(chice[i][j]==0) {
					for(int k=0;k<4;k++) {
						int x=i+dx[k];
						int y=j+dy[k];
						if(x>=0 && x<n && y>=0 && y<m && ice[x][y]>0)
							ice[x][y]--;
					}
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y]=true;
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int num[]=q.poll();
			for(int i=0;i<4;i++) {
				int nx=num[0]+dx[i];
				int ny=num[1]+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && ice[nx][ny]!=0 && !visited[nx][ny]) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
		}
	}
}
