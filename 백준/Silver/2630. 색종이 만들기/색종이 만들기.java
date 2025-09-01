import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static int n;
	static int[] result=new int[2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph=new int[n][n];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		fix(0,0,n);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	static void fix(int x,int y,int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(graph[x][y]!=graph[i][j]) {
					size/=2;
					fix(x,y,size);
					fix(x+size,y,size);
					fix(x,y+size,size);
					fix(x+size,y+size,size);
					return;
				}
			}
		}
		result[graph[x][y]]++;
		
	}
}
