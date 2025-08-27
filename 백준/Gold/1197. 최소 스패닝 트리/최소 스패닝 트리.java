import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int n;
	int cost;
	Node(int n,int cost){
		this.n=n;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Main {
	static List<Node> node[];
	static boolean[] visited;
	static int v,e,result=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		visited=new boolean[v+1];
		node=new ArrayList[v+1];
		for(int i=1;i<=v;i++)
			node[i] = new ArrayList<>();
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			node[a].add(new Node(b,c));
			node[b].add(new Node(a,c));
		}
		prim(1);
		System.out.println(result);
	}
	
	static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			if(visited[nd.n]) continue;
			result+=nd.cost;
			visited[nd.n]=true;
			for(Node n:node[nd.n]) {
				if(!visited[n.n]) {
					pq.add(n);
				}
			}
		}
	}
}
