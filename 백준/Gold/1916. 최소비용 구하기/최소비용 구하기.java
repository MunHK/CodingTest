import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<bus> list[];
	static int visit[];
	static int n,m;
	static int start,end;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		list=new ArrayList[n+1];
		visit=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<>();
			visit[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new bus(b,c));
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		dij();
		
		System.out.println(visit[end]);
	}
	static void dij() {
		PriorityQueue<bus> pq = new PriorityQueue<>();
		pq.add(new bus(start,0));
		visit[start]=0;
		while(!pq.isEmpty()) {
			bus now = pq.poll();
			if(now.v==end)
				break;
			for(bus next : list[now.v]) {
				if(visit[next.v]>next.cost+visit[now.v]) {
					visit[next.v]=next.cost+visit[now.v];
					pq.add(new bus(next.v,visit[next.v]));
				}
			}
		}
	}
}

class bus implements Comparable<bus>{
	int v,cost;
	bus(int v,int cost){
		this.v=v;
		this.cost=cost;
	}
	@Override
	public int compareTo(bus o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
	
}