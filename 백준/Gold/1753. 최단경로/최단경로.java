import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v,e,start;
	static List<Vertex> list[];
	static int result[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(br.readLine());
		
		list=new ArrayList[v+1];
		result=new int[v+1];
		
		for(int i=1;i<=v;i++) {
			list[i]=new ArrayList<>();
			result[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Vertex(b,c));
		}
		
		dij();
		for(int i=1;i<=v;i++) {
			System.out.println(result[i]==Integer.MAX_VALUE?"INF":result[i]);
		}
	}
	static void dij() {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(start,0));
		result[start]=0;
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			for(Vertex next : list[now.v]) {
				if(result[next.v]>result[now.v]+next.w) {
					pq.add(new Vertex(next.v,result[now.v]+next.w));
					result[next.v]=result[now.v]+next.w;
				}
			}
		}
	}
}

class Vertex implements Comparable<Vertex>{
	int v,w;
	Vertex(int v,int w){
		this.v=v;
		this.w=w;
	}
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.w, o.w);
	}
}