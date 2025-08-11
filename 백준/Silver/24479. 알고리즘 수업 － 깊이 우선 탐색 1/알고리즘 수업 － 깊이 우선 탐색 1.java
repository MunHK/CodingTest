import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static int n,m,cnt=1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		visited=new int[n];
		graph=new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a-1].add(b-1);
			graph[b-1].add(a-1);
		}
		
		for(int i=0;i<n;i++) {
			if(graph[i].size()!=0)
				Collections.sort(graph[i]);
		}
		dfs(r-1);
		for(int i=0;i<n;i++) {
			System.out.println(visited[i]);
		}
	}
	public static void dfs(int v) {
		visited[v]=cnt++;
		
		for(int i:graph[v]) {
			if(visited[i]==0)
				dfs(i);
		}
	}
}
