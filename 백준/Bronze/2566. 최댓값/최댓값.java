import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int mx=Integer.MIN_VALUE;
        int x=0,y=0;
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                int num=sc.nextInt();
                if(mx<num){ 
                    mx=num;
                    x=i;
                    y=j;
                }
            }
        }
        System.out.println(mx);
        System.out.println(x+" "+y);
    }
}