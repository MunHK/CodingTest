from collections import deque
n,m,k=map(int,input().split())
graph=[[0]*m for _ in range(n)]
for _ in range(k):
    ly,lx,ry,rx=map(int,input().split())
    for i in range(lx,rx):
        for j in range(ly,ry):
            graph[i][j]=1

def bfs(start,end):
    count=0
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    q=deque()
    q.append([start,end])
    while q:
        x,y=q.popleft()
        
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0:
                count+=1
                q.append([nx,ny])
                graph[nx][ny]=1
    return count if count!=0 else 1
result=[]
for i in range(n):
    for j in range(m):
        if graph[i][j]==0:
            result.append(bfs(i,j))
result.sort()
print(len(result))
print(*result)