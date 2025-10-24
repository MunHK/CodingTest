import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,result=0;
	static char[][] miro;
	static int visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Queue<JK> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		miro = new char[n][m];
		visited = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String in = br.readLine();
			for(int j=0;j<m;j++) {
				miro[i][j]=in.charAt(j);
				if(miro[i][j]=='J') {
					q.add(new JK(i,j,'J'));
					visited[i][j]=1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				switch(miro[i][j]) { // -1=불 , -2=벽
				case 'F':
					q.add(new JK(i,j,'F'));
					visited[i][j]=-1;
					break;
				case '#':
					visited[i][j]=-2;
				}
			}
		}
		escape();
		System.out.println(result==0?"IMPOSSIBLE":result);
	}
	private static void escape() {
		while(!q.isEmpty()) {
			int size=q.size();
			for(int t=0;t<size;t++) {
				JK jk = q.poll();
				for(int i=0;i<4;i++) {
					int nx = jk.x+dx[i];
					int ny = jk.y+dy[i];
					if(jk.jk=='J' && visited[jk.x][jk.y]>=0) {
						if(nx>=n || nx<0 || ny>=m || ny<0 ) {
							result=visited[jk.x][jk.y];
							return;
						}
					}
					if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]>=0) {
						if(jk.jk=='J' && visited[nx][ny]==0) {
							visited[nx][ny]=visited[jk.x][jk.y]+1;
							q.add(new JK(nx,ny,'J'));
						}
						else if(jk.jk=='F') {
							visited[nx][ny]=-1;
							q.add(new JK(nx,ny,'F'));
						}
					}
				}
			}
		}
	}
	static class JK{
		int x,y;
		char jk;
		JK(int x,int y,char jk){
			this.x=x;
			this.y=y;
			this.jk=jk;
		}
	}
}
