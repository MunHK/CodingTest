import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int n;
	double cost;

	Node(int n,double cost){
		this.n=n;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Double.compare(this.cost, o.cost);
	}
	
}

public class Solution {
	static int graph[][];
	static int n;
	static double result,tex;
	static List<Node> list[];
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			
			n=Integer.parseInt(br.readLine());
			list=new ArrayList[n];
			visited=new boolean[n];
			graph=new int[n][2];
			result=0;
			
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			tex=Double.parseDouble(br.readLine());
			
			for(int i=0;i<n;i++) {
				graph[i][0]=Integer.parseInt(stx.nextToken());
				graph[i][1]=Integer.parseInt(sty.nextToken());
				list[i]=new ArrayList<>();
			}
			
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					double d = Math.pow(graph[i][0]-graph[j][0], 2) + Math.pow(graph[i][1]-graph[j][1], 2);
					list[i].add(new Node(j,d));
					list[j].add(new Node(i,d));
				}
			}
			
			prim(1);
			System.out.println("#"+tc+" "+Math.round(result));
		}
	}
	static void prim(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.n]) continue;
			
			visited[node.n]=true;
			result+=node.cost*tex;
			for(Node p:list[node.n]) {
				if(!visited[p.n])
					pq.offer(p);
			}
		}
	}
}
