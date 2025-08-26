//20250826 크루스칼 기본 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Graph{
	@Override
	public String toString() {
		return "Graph [n=" + n + ", m=" + m + ", d=" + d + "]";
	}
	int n,m,d;
	Graph(int n,int m,int d){
		this.n=n;
		this.m=m;
		this.d=d;
	}
}
public class Main {
	static int n,m;
	static int tree[];
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		Graph g[] = new Graph[m];
		tree = new int[n];
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			g[i]=new Graph(n-1,m-1,d);
		}
		
		for(int i=0;i<n;i++) {
			tree[i]=i;
		}
		
		Arrays.sort(g,(a,b)->a.d-b.d);
		
		for(int i=0;i<m;i++) {
			if(find(g[i].n)!=find(g[i].m)) {
				union(g[i].n,g[i].m);
				result+=g[i].d;
			}
		}
		System.out.println(result);
	}
	
	static int find(int i) {
		if(tree[i]==i)
			return i;
		return find(tree[i]);
	}
	static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(a>b) {
			tree[aRoot]=bRoot;
		}else
			tree[bRoot]=aRoot;
	}
}
