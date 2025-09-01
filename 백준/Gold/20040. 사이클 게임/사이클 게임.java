import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static int parent[];
	static int n,m;
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		parent=new int[n];
		graph=new int[m][2];
		
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[i][0]=a;
			graph[i][1]=b;
		}
		
		for(int[] p:graph) {
			if(find(p[0])==find(p[1])) {
				break;
			}
			result+=1;
			union(p[0],p[1]);
		}
		
		System.out.println(result==m?0:result+1);
	}
	
	static int find(int i) {
		if(parent[i]==i)
			return i;
		return parent[i]=find(parent[i]);
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
}
