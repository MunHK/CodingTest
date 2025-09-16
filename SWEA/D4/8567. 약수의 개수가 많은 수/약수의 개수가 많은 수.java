import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int num[]=new int[100001];
		int result[]=new int[100001];
		for(int i=2;i<=100000;i++) {
			for(int j=i;j<=100000;j+=i) {
				num[j]++;
			}
		}
		for(int i=1;i<=100000;i++) {
			if(num[result[i-1]]>num[i])
				result[i]=result[i-1];
			else
				result[i]=i;
		}
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#"+tc+" "+result[n]);
		}
	}
}
