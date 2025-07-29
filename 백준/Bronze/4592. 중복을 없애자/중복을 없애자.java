import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> num = new ArrayList();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int cnt=0;
			int last=0;
			int n=Integer.parseInt(st.nextToken());
			if(n!=0) {
				last=Integer.parseInt(st.nextToken());
				num.add(last);
				cnt+=1;
				for(int i=0;i<n-1;i++) {
					last=Integer.parseInt(st.nextToken());
					if(num.get(cnt-1)!=last) {
						num.add(last);
						cnt+=1;
					}
				}
			}else
				break;
			for(int a:num)
				System.out.print(a+" ");
			System.out.println("$");
			num.clear();
		}
	}

}
