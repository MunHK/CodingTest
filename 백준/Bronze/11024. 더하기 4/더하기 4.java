import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int result=0;
			String[] in = br.readLine().split(" ");
			for(int i=0;i<in.length;i++) {
				result+=Integer.parseInt(in[i]);
			}
			System.out.println(result);
		}
	}
}
