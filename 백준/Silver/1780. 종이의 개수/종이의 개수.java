import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int map[][];
	static int result[]=new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map=new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,n);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}
	private static void divide(int x,int y,int len) {
		if(chk(x,y,len)) {
			result[map[x][y]+1]+=1;
			return;
		}
		int size=len/3;
		divide(x,y,size);
		divide(x,y+size,size);
		divide(x,y+size*2,size);
		
		divide(x+size,y,size);
		divide(x+size,y+size,size);
		divide(x+size,y+size*2,size);
		
		divide(x+size*2,y,size);
		divide(x+size*2,y+size,size);
		divide(x+size*2,y+size*2,size);
			
	}
	private static boolean chk(int x, int y, int len) {
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(map[i][j]!=map[x][y])
					return false;
			}
		}
		return true;
	}
	
}
