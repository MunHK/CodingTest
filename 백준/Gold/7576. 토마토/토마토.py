import sys
input=sys.stdin.readline
from collections import deque
n,m=map(int,input().split())
graph=[(list(map(int,input().split()))) for _ in range(m)]
q=deque()
mx=0
for i in range(m):
    for j in range(n):
        if graph[i][j]==1:
            q.append([i,j])

def bfs():
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<m and 0<=ny<n and graph[nx][ny]==0:
                q.append([nx,ny])
                graph[nx][ny]=graph[x][y]+1

bfs()
for i in graph:
    for j in i:
        if j==0:
            print(-1)
            exit(0)
    mx=max(mx,max(i))
print(mx-1)
