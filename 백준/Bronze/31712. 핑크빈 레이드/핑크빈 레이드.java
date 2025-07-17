import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n[]=new int[6];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n[i*2]=Integer.parseInt(st.nextToken());
            n[i*2+1]=Integer.parseInt(st.nextToken());
        }
        int num=Integer.parseInt(br.readLine())-n[1]-n[3]-n[5];
        int result=0;
        while(num>0){
            result+=1;
            if(result%n[0]==0)
                num-=n[1];
            if(result%n[2]==0)
                num-=n[3];
            if(result%n[4]==0)
                num-=n[5];
        }
        System.out.println(result);
        
    }
}