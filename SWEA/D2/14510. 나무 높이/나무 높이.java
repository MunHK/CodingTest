import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("Sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			int mx=0,odd=0,even=0;
			int result=0;
			int n = Integer.parseInt(br.readLine());
			int tree[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) {
				int a = Integer.parseInt(st.nextToken());
				tree[i]=a;
				mx=Math.max(mx, a);
			}
			
			for(int i=0;i<n;i++) {
				int dif = mx-tree[i];
				odd+=dif%2;
				even+=dif/2;
			}
			
			if(odd>even) {
				if(odd==1)
					result=1;
				else
					result+=odd*2-1;
			}
			
			else if(even>odd) {
				result=odd*2;
				even=(even-odd)*2;
				result+=even/3*2;
				even%=3;
				if(even==2)
					result+=2;
				else if(even==1)
					result+=1;
			}
			else {
				result=odd+even;
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
