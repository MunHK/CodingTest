import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Graph implements Comparable<Graph>{
	int a,b,c;
	Graph(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	@Override
	public int compareTo(Graph o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.c, o.c);
	}
}

public class Solution {
	static int v,e;
	static int parent[];
	static ArrayList<Graph> graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			long result=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			v=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			parent=new int[v+1];
			for(int i=1;i<=v;i++)
				parent[i]=i;
			graph=new ArrayList<>();
			for(int i=0;i<e;i++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph.add(new Graph(a,b,c));
			}
			Collections.sort(graph);
			
			for(int i=0;i<e;i++) {
				Graph g = graph.get(i);
				if(find(g.a)!=find(g.b)) {
					result+=g.c;
					union(g.a,g.b);
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
	static int find(int i) {
		if(parent[i]==i)
			return i;
		return parent[i]=find(parent[i]);
	}
}
