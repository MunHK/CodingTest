import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n=Integer.parseInt(br.readLine());
			int first=0,second=0;
			String[] word=new String[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				word[i]=st.nextToken();
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<n;i++) {
				if(i%2==1)
					if(n%2!=0)
						System.out.print(word[n/2+1+second++]+" ");
					else
						System.out.print(word[n/2+second++]+" ");
				else
					System.out.print(word[first++]+" ");
			}
			System.out.println();
		}
	}
}
