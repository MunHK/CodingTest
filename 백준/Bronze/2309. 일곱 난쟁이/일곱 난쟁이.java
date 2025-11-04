import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[] tall = new int[9];
	static List<Integer> list=new ArrayList<>();
	static int num=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			tall[i]=Integer.parseInt(br.readLine());
			num+=tall[i];
		}
		cal();
		Collections.sort(list);
		for(int result:list) {
			System.out.println(result);
		}
	}
	static void cal() {
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(tall[i]+tall[j]==num-100) {
					for(int k=0;k<9;k++) {
						if(k!=i && k!=j)
							list.add(tall[k]);
					}
					return;
				}
			}
		}
	}
}
