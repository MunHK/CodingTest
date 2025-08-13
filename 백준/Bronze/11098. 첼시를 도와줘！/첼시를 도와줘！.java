import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int p = Integer.parseInt(br.readLine());
			int mx=0,idx=0;
			String[][] mem = new String[p][2];
			for(int j=0;j<p;j++) {
				mem[j]=br.readLine().split(" ");
				if(Integer.parseInt(mem[j][0])>mx) {
					idx=j;
					mx=Integer.parseInt(mem[j][0]);
				}
			}
			System.out.println(mem[idx][1]);
		}
	}
}