import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Monkey implements Comparable<Monkey>{
	@Override
	public String toString() {
		return "Monkey [a=" + a + ", b=" + b + ", c=" + c + "]\n";
	}
	int a,b,c;
	Monkey(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	@Override
	public int compareTo(Monkey o) {
		return this.c-o.c;
	}
}
public class Main {
	static ArrayList<Monkey> monkey;
	static int[] parent;
	static int n,m,result=0;
	static int mx=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		monkey=new ArrayList<>();
		parent=new int[n+1];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			monkey.add(new Monkey(a,b,c));
		}
		
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
		
		Collections.sort(monkey);
		
		for(int i=0;i<m;i++) {
			Monkey m = monkey.get(i);
			if(find(m.a)!=find(m.b)) {
				union(m.a,m.b);
				result+=m.c;
				mx=m.c;
			}
		}
		System.out.println(result-mx);
	}
	
	public static int find(int i) {
		if(parent[i]==i)
			return i;
		return parent[i]=find(parent[i]);
	}
	
	public static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
}
