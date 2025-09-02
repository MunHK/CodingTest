import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Party implements Comparable<Party>{
    int v,cost;
    Party(int v,int cost){
        this.v=v;
        this.cost=cost;
    }
    @Override
    public int compareTo(Party o) {
        // TODO Auto-generated method stub
        return Integer.compare(this.cost, o.cost);
    }
    
}

public class Main {
    static List<Party> list[];
    static int n,m,x;
    static int visit[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        
        visit=new int[n+1][n+1];
        list=new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
            list[i]=new ArrayList<>();
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Party(b,c));
        }
        for(int i=1;i<=n;i++) {
            dij(i);
        }
        int result=0;
        for(int i=1;i<=n;i++) {
        	if(i==x) continue;
        	result=Math.max(result, visit[i][x]+visit[x][i]);
        }
        System.out.println(result);
    }
    static void dij(int start) {
        PriorityQueue<Party> pq = new PriorityQueue<>();
        pq.add(new Party(start,0));
        visit[start][start]=0;
        while(!pq.isEmpty()) {
        	Party now = pq.poll();
        	if(start!=x && now.v==x)
        		break;
        	
        	for(Party next:list[now.v]) {
        		if(visit[start][next.v]>now.cost+next.cost) {
        			visit[start][next.v]=now.cost+next.cost;
        			pq.add(new Party(next.v,visit[start][next.v]));
        		}
        	}
        }
    }
}