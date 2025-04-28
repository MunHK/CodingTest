import sys
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]

dx=[1,-1,0,0]
dy=[0,0,1,-1]
result=[]

def bfs(start,end):
    q=[[start,end]]
    graph[start][end]=0
    count=0
    while q:
        x,y=q.pop(0)
        count+=1
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny]==1:
                q.append([nx,ny])
                graph[nx][ny]=0
    result.append(count)

for i in range(n):
    for j in range(m):
        if graph[i][j]==1:
            bfs(i,j)
print(len(result))
print(max(result) if len(result)!=0 else 0)