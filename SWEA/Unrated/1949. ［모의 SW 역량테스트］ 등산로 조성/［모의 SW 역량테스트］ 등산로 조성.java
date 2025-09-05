import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,k,mx;
	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			map=new int[n][n];
			visited=new boolean[n][n];
			mx=0; result=0;
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					mx=Math.max(mx, map[i][j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==mx) {
						visited[i][j]=true;
						dfs(i,j,mx,1,false);
						visited[i][j]=false;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	static void dfs(int x,int y,int height,int cnt,boolean cut) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
				if(height>map[nx][ny]) {
					visited[nx][ny]=true;
					dfs(nx,ny,map[nx][ny],cnt+1,cut);
					visited[nx][ny]=false;
				}
				else {
					if(!cut) {
						if(Math.abs(map[x][y]-map[nx][ny])+1<=k) {
							visited[nx][ny]=true;
							dfs(nx,ny,map[x][y]-1,cnt+1,true);
							visited[nx][ny]=false;
						}
					}
				}
			}
		}
		result=Math.max(result, cnt);
		
	}
}
