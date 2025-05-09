t=int(input())
for case in range(1,t+1):
    n,k=map(int,input().split())
    graph=[]

    dx=[0,-1,0,0]
    dy=[1,0,1,-1]
    result=0
    for _ in range(n):
        graph.append(list(map(int,input().split())))

    def dfs(x,y,cnt,right):
        global result
        if right:
            svisited[x][y]=True
            nx = x
            ny = y + 1
        else:
            dvisited[x][y]=True
            nx = x+1
            ny=y
        if 0<=nx<n and 0<=ny<n and graph[nx][ny]==1:
            dfs(nx,ny,cnt+1,right)
        else:
            if cnt==k:
                result+=1

    svisited=[[False]*n for _ in range(n)]
    dvisited=[[False]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j]==1:
                if not svisited[i][j]:
                    dfs(i,j,1,True)
                if not dvisited[i][j]:
                    dfs(i,j,1,False)
    print(f'#{case} {result}')