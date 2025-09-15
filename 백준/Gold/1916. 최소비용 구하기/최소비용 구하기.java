import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,start,end;
	static List<Bus> list[];
	static int[] visit;
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		list=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new ArrayList<>();
		}
		visit=new int[n+1];
		Arrays.fill(visit, -1);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Bus(b,c));
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		dij();
		System.out.println(result);
	}
	
	static void dij() {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start,0));
		visit[start]=0;
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			if(now.go==end) {
				result=now.cost;
				break;
			}
			for(Bus next:list[now.go]) {
				if(visit[next.go]==-1) {
					visit[next.go]=visit[now.go]+next.cost;
					pq.add(new Bus(next.go,visit[next.go]));
				}
				else if(visit[next.go]>visit[now.go]+next.cost) {
					visit[next.go]=visit[now.go]+next.cost;
					pq.add(new Bus(next.go,visit[next.go]));
				}
			}
		}
	}
	
	static class Bus implements Comparable<Bus>{
		int go,cost;
		Bus(int go,int cost){
			this.go=go;
			this.cost=cost;
		}
		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}
}
