import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int v,w;
	Node(int v,int w){
		this.v=v;
		this.w=w;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.w, o.w);
	}
	
}
public class Main {
	static List<Node> list[];
	static int v,e;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(br.readLine());
		
		list=new ArrayList[v+1];
		result=new int[v+1];
		for(int i=1;i<=v;i++) {
			list[i]=new ArrayList<>();
			result[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
		}
		bfs(start);
		for(int i=1;i<=v;i++) {
			System.out.println(result[i]!=Integer.MAX_VALUE?result[i]:"INF");
		}
	}
	static void bfs(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		result[start]=0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(result[node.v]<node.w) continue;
			
			for(Node p : list[node.v]) {// 2 2, 3 3
				if(result[p.v]>node.w+p.w) {
					result[p.v]=node.w+p.w;
					q.add(new Node(p.v,result[p.v]));
				}
			}
		}
	}
}
