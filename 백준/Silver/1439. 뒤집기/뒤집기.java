import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] result=new int[2];
		String[] word = br.readLine().split("");
		int now = Integer.parseInt(word[0]);
		result[now]++;
		for(int i=1;i<word.length;i++) {
			int num=Integer.parseInt(word[i]);
			if(now==num)
				continue;
			result[num]++;
			now=num;
		}
		System.out.println(Math.min(result[0], result[1]));
	}
}
