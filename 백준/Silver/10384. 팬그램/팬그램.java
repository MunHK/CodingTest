import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=t;test_case++) {
			char[] al = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			int[] cnt = new int[26];
			String[] in = br.readLine().split("");
			for(int i=0;i<26;i++) {
				for(int j=0;j<in.length;j++) {
					if((in[j].toLowerCase()).equals(String.valueOf(al[i]))) {
						cnt[i]+=1;
					}
				}
			}
			int mn=Integer.MAX_VALUE;
			for(int i=0;i<26;i++) {
				mn=Math.min(mn, cnt[i]);
			}
			switch(mn) {
			case 0:
				System.out.println("Case "+test_case+": Not a pangram");
				break;
			case 1:
				System.out.println("Case "+test_case+": Pangram!");
				break;
			case 2:
				System.out.println("Case "+test_case+": Double pangram!!");
				break;
			case 3:
			default:
				System.out.println("Case "+test_case+": Triple pangram!!!");
				break;
			}
		}
	}
}
