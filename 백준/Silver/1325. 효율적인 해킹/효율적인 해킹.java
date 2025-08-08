import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] graph;
	static int[] cnt;
	static boolean[] visited;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		graph=new ArrayList[n+1];
		
		for(int i=0;i<=n;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		
		visited=new boolean[n+1];
		cnt=new int[n+1];
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[b].add(a);
		}
		
		int mx=0;
		for(int i=1;i<=n;i++) {
			bfs(i);
			if(cnt[i]>mx)
			    mx=cnt[i];
			Arrays.fill(visited, false);
            
		}
		
		for(int i=1;i<=n;i++) {
			if(cnt[i]==mx)
				sb.append(i).append(" ");
		}
		
		System.out.println(sb);
		
	}
	public static void bfs(int start) {
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int v=q.poll();
			for(int x:graph[v]) {
				if(!visited[x]) {
					if(graph[x].size()!=0)
						q.add(x);
					visited[x]=true;
					cnt[start]++;
				}
			}
		}
	}
}