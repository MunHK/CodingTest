import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> graph[];
	static int[] visited;
	static int n,start,end,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(br.readLine());
		
		graph=new ArrayList[n+1];
		visited=new int[n+1];
		
		for(int i=0;i<=n;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		bfs(start);
		if(visited[end]==0)
			System.out.println(-1);
		else
			System.out.println(visited[end]-1);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x]=1;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i:graph[v]) {
				if(visited[i]==0) {
					q.add(i);
					visited[i]=visited[v]+1;
				}
			}
		}
	}
}