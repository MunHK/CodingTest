import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken())-1;
		int cnt=0;
		List<Integer> num=new LinkedList<>();
		
		for(int i=1;i<=a;i++) {
			num.add(i);
		}
		System.out.print("<");
		while(a!=1) {
			cnt=(cnt+b)%a;
			System.out.printf("%d, ",num.get(cnt));
			a-=1;
			num.remove(cnt);
		}
		System.out.printf("%d>",num.get(0));
	}
}