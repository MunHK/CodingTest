import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,cnt,result;
	static int[][] map;
	static List<int[]> list;
	static boolean[] visit;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		list=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0)
					list.add(new int[] {i,j});
			}
		}
		visit=new boolean[list.size()];
		Recursive(new int[3],0,0);
		System.out.println(result);
	}
	
	static void bfs(int x,int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		while(!q.isEmpty()) {
			int num[]=q.poll();
			x=num[0]; y=num[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]==0) {
					visited[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	static void Recursive(int[] arr, int idx,int start) {
		if(idx==3) {
			int a[] = list.get(arr[0]);
			int b[] = list.get(arr[1]);
			int c[] = list.get(arr[2]);
			map[a[0]][a[1]]=1;
			map[b[0]][b[1]]=1;
			map[c[0]][c[1]]=1;
			visited=new boolean[n][m];
			cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==2 && !visited[i][j])
						bfs(i,j);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!visited[i][j] && map[i][j]==0) {
						cnt++;
					}
				}
			}
			result=Math.max(result, cnt);
			map[a[0]][a[1]]=0;
			map[b[0]][b[1]]=0;
			map[c[0]][c[1]]=0;
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[idx]=i;
				Recursive(arr,idx+1,i+1);
				visit[i]=false;
				arr[idx]=0;
			}
		}
	}
	
	
}
