import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int result=0;
        for(int i=0;i<num.length();i++){
            result+=num.charAt(i)-48;
        }
        System.out.println(result);
    }
}