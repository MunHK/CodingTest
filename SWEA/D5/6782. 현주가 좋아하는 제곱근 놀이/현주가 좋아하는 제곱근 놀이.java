import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			long n=Long.parseLong(br.readLine());
			long result=0;
			while(n!=2) {
				if((long)Math.sqrt(n)*(long)Math.sqrt(n)==n) {
					n=(long)Math.sqrt(n);
					result++;
				}
				else {
					result+=(long) Math.pow((long)Math.sqrt(n)+1,2)-n;
					n=(long) Math.pow((long)Math.sqrt(n)+1,2);
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
