import sys
from collections import deque
input=sys.stdin.readline
n,m=map(int,input().split())
graph=[]
q=deque()

for i in range(m):
    a=list(map(int,input().split()))
    graph.append(a)
    for j in range(n):
        if a[j]==1:
            q.append([i,j])
def bfs(q):
    mx=0
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
                mx=max(graph[nx][ny],mx)
    return mx

flag=False
for i in range(m):
    if 0 in graph[i]:
        flag=True
if flag:
    mx=bfs(q)
    for i in range(m):
        if 0 in graph[i]:
            flag=False
    if flag:
        print(mx-1)
    else:
        print(-1)
else:
    print(0)





