for case in range(int(input())):
    n,m=map(int,input().split())
    
    graph=[[] for _ in range(n+1)]
    visited=[False]*(n+1)
    for _ in range(m):
        a,b=map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    result=[]
    
    def dfs(v,cnt):
        result.append(cnt)
        for i in graph[v]:
            if not visited[i]:
                visited[i]=True
                dfs(i,cnt+1)
                visited[i]=False
    for i in range(1,n+1):
        visited[i]=True
        dfs(i,1)
        visited[i]=False
    print(f'#{case+1} {max(result)}')