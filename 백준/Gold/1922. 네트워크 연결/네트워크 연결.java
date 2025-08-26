//20250826 크루스칼 기본 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Graph implements Comparable<Graph>{
	int n,m,d;
	Graph(int n,int m,int d){
		this.n=n;
		this.m=m;
		this.d=d;
	}
	@Override
	public int compareTo(Graph o) {
		// TODO Auto-generated method stub
		return this.d-o.d;
	}
}
public class Main {
	static int n,m;
	static int tree[];
	static int result=0;
	static ArrayList<Graph> g;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		g=new ArrayList<>();
		tree = new int[n];
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			g.add(new Graph(n-1,m-1,d));
		}
		
		for(int i=0;i<n;i++) {
			tree[i]=i;
		}
		
		Collections.sort(g);
		
		for(int i=0;i<m;i++) {
			Graph gm = g.get(i);
			if(find(gm.n)!=find(gm.m)) {
				union(gm.n,gm.m);
				result+=gm.d;
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
		a = find(a);
		b = find(b);
		if(a!=b)
			tree[b]=a;
	}
}
