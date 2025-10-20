import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,calnum,max,min;
    static int num[];
    static int in[];
    static List<Integer> cal;
    static boolean visited[];
    static int nlist[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n=Integer.parseInt(br.readLine());
        
        num=new int[n];
        in=new int[4];
        cal=new ArrayList<>();
        calnum=0;
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) 
            num[i]=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            in[i]=Integer.parseInt(st.nextToken());
            for(int k=0;k<in[i];k++) {
                cal.add(i+1);
            }
        }
        visited=new boolean[n-1];
        nlist=new int[n-1];
        recursive(0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void recursive(int idx) {
        if(idx==n-1) {
        	int result=num[0];
            for(int i=0;i<n-1;i++) {
            	int calnum=nlist[i];
            	switch(calnum) {
            	case 1:
            		result+=num[i+1];
            		break;
            	case 2:
            		result-=num[i+1];
            		break;
            	case 3:
            		result*=num[i+1];
            		break;
            	case 4:
            		result/=num[i+1];
            		break;
            	}
            }
            if(result>max)
            	max=result;
            if(result<min)
            	min=result;
            return;
        }
        for(int i=0;i<n-1;i++) {
            if(!visited[i]) {
                visited[i]=true;
                nlist[idx]=cal.get(i);
                recursive(idx+1);
                visited[i]=false;
            }
        }
    }
}
