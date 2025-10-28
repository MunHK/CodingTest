import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int n,m,result=0;
	static int graph[][];
	static Robot robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int way=Integer.parseInt(st.nextToken());
		robot=new Robot(start, end, way);
		
		graph=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				graph[i][j]=Integer.parseInt(st.nextToken());
		}
		
		bfs();
		System.out.println(result);
	}
	private static void bfs() {
		while(true) {
			boolean clean=true;
			if(graph[robot.x][robot.y]==0) {
				graph[robot.x][robot.y]=2;
				result+=1;
			}
			for(int i=0;i<4;i++) {
				int nx=robot.x+dx[i];
				int ny=robot.y+dy[i];
				if(graph[nx][ny]==0) {
					clean=false;
					break;
				}
			}
			if(clean) {
				int nx=robot.x+dx[(robot.d+2)%4];//0 2, 1 3
				int ny=robot.y+dy[(robot.d+2)%4];
				if(graph[nx][ny]!=1) {
					robot.x=nx;	robot.y=ny;
					continue;
				}else {
					return;
				}
			}else {
				robot.d=(robot.d-1==-1?3:robot.d-1);
				int nx=robot.x+dx[robot.d];
				int ny=robot.y+dy[robot.d];
				if(graph[nx][ny]==0) {
					robot.x=nx;
					robot.y=ny;
				}
			}
		}
	}
	static class Robot{
		int x,y,d;
		Robot(int x,int y,int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
}
