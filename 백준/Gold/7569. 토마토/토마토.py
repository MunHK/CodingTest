import sys
from collections import deque

input=sys.stdin.readline
m,n,k=map(int,input().split())
graph=[[] for _ in range(k)]
q=deque()
dx=[1,-1,0,0,0,0]
dy=[0,0,1,-1,0,0]
dh=[0,0,0,0,1,-1]
for i in range(k):
    for j in range(n):
        graph[i].append(list(map(int,input().split())))
        for h in range(m):
            if graph[i][j][h]==1:
                q.append([i,j,h])

def bfs():
    while q:
        h,x,y=q.popleft()
        for i in range(6):
            nx=x+dx[i]
            ny=y+dy[i]
            nh=h+dh[i]
            if 0<=nx<n and 0<=ny<m and 0<=nh<k and graph[nh][nx][ny]==0:
                q.append([nh,nx,ny])
                graph[nh][nx][ny]=graph[h][x][y]+1
mx=0
bfs()
for pan in graph:
    for line in pan:
        if 0 in line:
            print(-1)
            exit(0)
        mx=max(mx,max(line))
print(mx-1)