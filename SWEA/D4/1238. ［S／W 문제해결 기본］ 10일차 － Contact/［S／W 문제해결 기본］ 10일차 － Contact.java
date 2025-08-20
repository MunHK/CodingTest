import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int n,start;
	static int[] visited;
	static int mx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph=new int[101][101];
			visited=new int[101];
			mx=0;
			int result=0;
			st=new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<n/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to]=1;
			}
			bfs();
			for(int i=1;i<101;i++) {
				if(mx==visited[i])
					result=i;
			}
			System.out.println("#"+t+" "+result);
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]=1;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i=1;i<101;i++) {
				if(graph[v][i]==1 && visited[i]==0) {
					q.add(i);
					visited[i]=visited[v]+1;
					mx=Math.max(mx, visited[i]);
				}
			}
		}
	}
}
