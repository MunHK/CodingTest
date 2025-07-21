import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        for(int i=0;i<num.length();i++){
            sb.append(num.charAt(i)-64).append(" ");
        }
        System.out.println(sb.toString());
    }
}