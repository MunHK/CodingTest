import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph=new int[n+1][n+1];
		visited=new boolean[n+1];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b]=graph[b][a]=1;
		}
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt=0;
		q.add(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i=1;i<=n;i++) {
				if(graph[v][i]==1 & !visited[i]) {
					q.add(i);
					visited[i]=true;
					cnt+=1;
				}
			}
		}
		return cnt;
	}
}