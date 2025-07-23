import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int num=665;
        while(n!=0){
            num+=1;
            if(Integer.toString(num).contains("666"))
                n-=1;
        }
        System.out.println(num);
    }
}