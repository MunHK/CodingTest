import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        
        int total = n;
        int bonus = n / m;
        
        while (bonus > 0) {
            total += bonus;
            bonus = bonus / m;
        }
        
        System.out.println(total);
    }
}
