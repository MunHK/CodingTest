from collections import deque
case=int(input())
dx=[-2,-2,-1,-1,2,2,1,1]
dy=[-1,1,-2,2,-1,1,-2,2]

def bfs(graph):
    while q:
        x,y=q.popleft()
        if x==endx and y==endy:
            break
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<l and 0<=ny<l and graph[nx][ny]==0:
                q.append([nx,ny])
                graph[nx][ny]=graph[x][y]+1

for _ in range(case):
    l=int(input())
    graph=[[0]*l for _ in range(l)]

    a,b=map(int,input().split())
    graph[a][b]=1
    q=deque()
    q.append([a,b])
    endx,endy=map(int,input().split())
    bfs(graph)
    print(graph[endx][endy]-1)

    





