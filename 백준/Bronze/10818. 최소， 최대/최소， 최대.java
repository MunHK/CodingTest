import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String[] word=br.readLine().split(" ");
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(Integer.parseInt(word[i])<min){
                min=Integer.parseInt(word[i]);
            }
            if(Integer.parseInt(word[i])>max){
                max=Integer.parseInt(word[i]);
            }
        }
        System.out.println(min+" "+max);
    }
}