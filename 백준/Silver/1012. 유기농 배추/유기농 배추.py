from collections import deque
import sys

input=sys.stdin.readline
dx=[1,-1,0,0]
dy=[0,0,1,-1]
case=int(input())

def bfs(start,end,graph):
    q=deque([[start,end]])
    graph[start][end]=0
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m and graph[nx][ny]==1:
                q.append([nx,ny])
                graph[nx][ny]=0

for _ in range(case):
    count=0
    n,m,k=map(int,input().split())
    graph=[[0]*m for _ in range(n)]

    for _ in range(k):
        a,b=map(int,input().split())
        graph[a][b]=1

    for i in range(n):
        for j in range(m):
            if graph[i][j]==1:
                bfs(i,j,graph)
                count+=1
    print(count)
    



    