import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		Queue<Integer> num = new LinkedList<>();
		for(int i=1;i<=a;i++)
			num.add(i);
		System.out.print("<");
		while(!num.isEmpty()) {
			for(int i=0;i<b-1;i++) {
				num.add(num.poll());
			}
			if(num.size()==1)
				System.out.println(num.poll()+">");
			else
				System.out.print(num.poll()+", ");
		}
	}
}