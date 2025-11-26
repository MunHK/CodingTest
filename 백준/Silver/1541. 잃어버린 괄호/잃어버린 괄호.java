import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minusSplit = br.readLine().split("-");

        int result = 0;

        // 첫번째 덩어리는 전부 더하기
        for (String s : minusSplit[0].split("\\+")) {
            result += Integer.parseInt(s);
        }

        // 그 뒤 덩어리는 전부 더한 후 result에서 빼기
        for (int i = 1; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int sum = 0;
            for (String s : plusSplit) {
                sum += Integer.parseInt(s);
            }
            result -= sum;
        }

        System.out.println(result);
    }
}
