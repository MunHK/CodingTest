import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int num;
			if(b==0)
				num=1;
			else
				num=a;
			for(int i=1;i<b;i++) {
				num=(a*num)%10;
			}
			if((num%10)!=0)
				System.out.println(num%10);
			else
				System.out.println(10);
		}
	}
}
