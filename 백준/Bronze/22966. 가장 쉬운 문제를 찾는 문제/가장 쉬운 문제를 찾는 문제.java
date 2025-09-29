import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mx=Integer.MAX_VALUE;
		String result=null;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(num<mx) {
				mx=num;
				result=word;
			}
		}
		System.out.println(result);
	}

}
