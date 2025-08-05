import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	int n=Integer.parseInt(st.nextToken());
    	int m=Integer.parseInt(st.nextToken());
    	int start=Integer.parseInt(st.nextToken());
    	
    	graph=new int[n+1][n+1];
    	visited=new boolean[n+1];
    	
    	for(int i=0;i<m;i++) {
    		st=new StringTokenizer(br.readLine()," ");
    		int a=Integer.parseInt(st.nextToken());
    		int b=Integer.parseInt(st.nextToken());
    		graph[a][b]=graph[b][a]=1;
    	}
    	dfs(start);
    	sb.append("\n");
    	visited=new boolean[n+1];
    	bfs(start);
    	System.out.println(sb);
    }
    
    public static void dfs(int start) {
    	visited[start]=true;
    	sb.append(start).append(" ");
    	for(int i=0;i<graph[start].length;i++) {
    		if(graph[start][i]==1 & !visited[i])
    			dfs(i);
    	}
    }
    
    public static void bfs(int start) {
    	queue.add(start);
    	visited[start]=true;
    	while(!(queue.isEmpty())) {
    		int v = queue.poll();
    		sb.append(v).append(" ");
    		for(int i=0;i<graph[v].length;i++) {
    			if(graph[v][i]==1 & !visited[i]) {
    				queue.add(i);
    				visited[i]=true;
    			}
    		}
    	}
    }
}
