import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			map=new int[n][n];
			int result=0;
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int k=1;k<=n+1;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(k==1){
							if(map[i][j]==1)
								result=1;
							continue;
						}
						visited=new boolean[n][n];
						int num=k*k+(k-1)*(k-1);
						int cnt=bfs(i,j,k);
						if(cnt*m-num>=0)
							result=Math.max(result, cnt);
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static int bfs(int x,int y,int idx) {
		int cnt=0,turn=1;
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y]=true;
		q.add(new int[] {x,y});
		if(map[x][y]==1)
			cnt+=1;
		while(!q.isEmpty() && idx>turn) {
			int size=q.size();
			for(int k=0;k<size;k++) {
				int num[]=q.poll();
				x=num[0]; y=num[1];
				for(int i=0;i<4;i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny]=true;
						if(map[nx][ny]==1)
							cnt+=1;
					}
				}
			}
			turn+=1;
		}
		return cnt;
	}
}
