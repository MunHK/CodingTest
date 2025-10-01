import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int graph[][];
	static String result="YES";
	static int visit[];
	static int start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		graph=new int[n][n];
		visit=new int[n];
		for(int i=0;i<n;i++) {
			visit[i]=i;
		}
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				if(graph[i][j]==1)
					if(find(i)!=find(j))
						union(i,j);
			}
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken())-1;
		for(int i=1;i<m;i++) {
			int num=Integer.parseInt(st.nextToken())-1;
			if(find(start)!=find(num)) {
				result="NO";
				break;
			}
			start=num;
		}
		System.out.println(result);
	}
	static int find(int i) {
		if(visit[i]==i)
			return i;
		return visit[i]=find(visit[i]);
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) visit[a]=b;
	}
}
