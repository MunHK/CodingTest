import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int graph[][]=new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<9;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sudo(0,0);
	}
	
	public static void sudo(int width,int height) {
		if(height==9) {
			sudo(width+1,0);
			return;
		}
		if(width==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(graph[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(graph[width][height]==0) {
			for(int n=1;n<=9;n++) {
				if(can(width,height,n)) {
					graph[width][height]=n;
					sudo(width,height+1);
					graph[width][height]=0;
				}
			}
		}
		else
			sudo(width,height+1);
	}
	public static boolean can(int x,int y,int idx) {
		for(int i=0;i<9;i++) {
			if(graph[x][i]==idx)
				return false;
			if(graph[i][y]==idx)
				return false;
		}
		x=x/3;
		y=y/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(graph[i+x*3][j+y*3]==idx)
					return false;
			}
		}
		return true;
	}
}
