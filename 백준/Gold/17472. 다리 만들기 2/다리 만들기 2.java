//20250826 과제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Loc{
	@Override
	public String toString() {
		return "Loc [x=" + x + ", y=" + y + "]";
	}
	int x,y;
	Loc(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class Vertex implements Comparable<Vertex>{
	@Override
	public String toString() {
		return "Vertex [a=" + a + ", b=" + b + ", cost=" + cost + "]";
	}
	int a,b,cost;
	Vertex(int a,int b,int cost){
		this.a=a;
		this.b=b;
		this.cost=cost;
	}
	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
	
}
public class Main {
	static int[][] graph;
	static int n,m,cnt;
	static int[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static ArrayList<Loc> side;
	static int how=-1;
	static ArrayList<Vertex> vertex;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result=0;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		visited=new int[n][m];
		side = new ArrayList<>();
		vertex=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		GiveName();
		for(Loc l : side) {
			for(int i=0;i<4;i++) {
				visited=new int[n][m];
				dfs(l.x,l.y,i,graph[l.x][l.y]);
				how=-1;
			}
		}
		parent= new int[cnt];
		for(int i=1;i<cnt;i++) {
			parent[i]=i;
		}
		Collections.sort(vertex);
		for(int i=0;i<vertex.size();i++) {
			Vertex vt = vertex.get(i);
			if(find(vt.a)!=find(vt.b)) {
				union(vt.a,vt.b);
				result+=vt.cost;
			}
		}
		int chk=find(parent[1]);
		for(int i=2;i<cnt;i++) {
			if(chk!=find(parent[i]))
				result=-1;
		}
		System.out.println(result);
		
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
	
	
	static void dfs(int x,int y,int di,int start) {
		how++;
		visited[x][y]=1;
		int nx=x+dx[di];
		int ny=y+dy[di];
		if(nx>=0 && nx<n && ny>=0 && ny<m) {
			if(graph[nx][ny]==0 && visited[nx][ny]==0) {
				visited[nx][ny]=1;
				dfs(nx,ny,di,start);
			}
			else if(graph[nx][ny]!=0 && graph[nx][ny]!=start && how>1) {
				vertex.add(new Vertex(start,graph[nx][ny],how));
				return;
			}else
				return;
		}else 
			return;
	}
	
	static void GiveName() {
		cnt=1;
		boolean[][] xy=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1 && visited[i][j]==0) {
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i,j});
					visited[i][j]=1;
					graph[i][j]=cnt;
					while(!q.isEmpty()) {
						int num[]=q.poll();
						int x=num[0];
						int y=num[1];
						for(int k=0;k<4;k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(nx>=0 && nx<n && ny>=0 && ny<m) {
								if(graph[nx][ny]==1 && visited[nx][ny]==0) {
									q.add(new int[] {nx,ny});
									visited[nx][ny]=1;
									graph[nx][ny]=cnt;
								}
								else if(graph[nx][ny]==0) {
									if(!xy[x][y]) {
										side.add(new Loc(x,y));
										xy[x][y]=true;
									}
								}
							}
						}
					}
					cnt++;
				}
			}
		}
	}
}
