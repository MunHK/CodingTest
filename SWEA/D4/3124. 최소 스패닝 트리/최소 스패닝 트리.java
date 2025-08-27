import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex>{
	int v,cost;
	Vertex(int v,int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Solution {
	static List<Vertex> list[];
	static boolean[] visited;
	static int v,e;
	static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			list=new ArrayList[v+1];
			result=0;
			visited=new boolean[v+1];
			
			for(int i=1;i<=v;i++) 
				list[i]=new ArrayList<>();
			
			for(int i=0;i<e;i++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Vertex(b,c));
				list[b].add(new Vertex(a,c));
			}
			prim(1);
			
			System.out.println("#"+tc+" "+result);
		}
		
	}
	
	static void prim(int start) {
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start,0));
		while(!pq.isEmpty()) {
			Vertex ver = pq.poll();
			if(visited[ver.v]) continue;
			
			result+=ver.cost;
			visited[ver.v]=true;
			for(Vertex p : list[ver.v]) {
				if(!visited[p.v])
					pq.offer(p);
			}
		}
	}
}
