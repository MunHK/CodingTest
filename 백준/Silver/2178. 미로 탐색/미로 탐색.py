import sys
input=sys.stdin.readline
n,m=map(int,input().split())

graph=[]
queue=[]
dx=[1,-1,0,0]
dy=[0,0,1,-1]

for _ in range(n):
    graph.append(list(map(int,input().strip())))
    
def bfs(x,y):
    queue.append([x,y])
    while queue:
        x,y=queue.pop(0)
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if graph[nx][ny]==1:
                queue.append([nx,ny])
                graph[nx][ny]=graph[x][y]+1

bfs(0,0)
print(graph[n-1][m-1])


