import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static Set<String> result;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			graph=new int[4][4];
			result=new HashSet<String>();
			
			for(int i=0;i<4;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					dfs(i,j,Integer.toString(graph[i][j]));
				}
			}
			System.out.println("#"+tc+" "+result.size());
		}
	}
	static void dfs(int x,int y,String arr) {
		if(arr.length()==7) {
			result.add(arr);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<4 && ny>=0 && ny<4) {
				dfs(nx,ny,arr+Integer.toString(graph[nx][ny]));
			}
		}
	}
}
