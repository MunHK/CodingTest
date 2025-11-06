import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String s = br.readLine();
            
            if (s.equals("0")) break;  // 입력의 끝
            
            String reversed = new StringBuilder(s).reverse().toString();
            
            if (s.equals(reversed))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
