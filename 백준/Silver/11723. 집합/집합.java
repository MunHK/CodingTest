import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] all=new int[21];
	static int[] list=new int[21];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		Arrays.fill(all, 1);
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			int num=0;
			if(!com.equals("all") && !com.equals("empty"))
				num = Integer.parseInt(st.nextToken());
			
			switch(com) {
			case "add":
				list[num]=1;
				break;
			case "remove":
				list[num]=0;
				break;
			case "check":
				sb.append(list[num]).append("\n");
				break;
			case "toggle":
				list[num]=(list[num]==1?0:1);
				break;
			case "all":
				System.arraycopy(all, 0, list, 0, 21);
				break;
			case "empty":
				list=new int[21];
				break;
				
			}
		}
		System.out.println(sb.toString());
	}
}
