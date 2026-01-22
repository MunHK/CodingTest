import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static String[] name;
	static int n;
	static int YFO;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		char in = st.nextToken().charAt(0);
		
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(br.readLine());
		}
		
		if(in=='Y')
			System.out.println(set.size());
		else if(in=='F')
			System.out.println(set.size()/2);
		else
			System.out.println(set.size()/3);
	}
}
