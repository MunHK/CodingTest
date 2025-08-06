import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static Queue<Integer> q = new LinkedList<>();
	static int graph[][];
	static int visited[];
	static int n,m;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		graph=new int[n+1][n+1];
		visited=new int[n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[a][b]=graph[b][a]=1;
		}
		bfs(1);
		for(int i=2;i<=n;i++) {
			if(visited[i]<=3 & visited[i]!=0)
				result+=1;
		}
		System.out.println(result);
	}
	public static void bfs(int start) {
		q.add(start);
		visited[start]=1;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i=0;i<graph[v].length;i++) {
				if(graph[v][i]==1 & visited[i]==0) {
					q.add(i);
					visited[i]=visited[v]+1;
				}
			}
		}
	}
}