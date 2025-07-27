import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int num[][] = new int[n][m];
        int mum[][] = new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                num[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                mum[i][j]=num[i][j]+Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(mum[i][j]+" ");
            System.out.println();
        }        
    }
}