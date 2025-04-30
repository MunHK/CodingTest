from collections import deque
import copy

n=int(input())
graph=[]
dx=[1,-1,0,0]
dy=[0,0,1,-1]
for _ in range(n):
    graph.append(list(map(int,input().split())))
mx=[0]*101

def bfs(map,start,end,p):
    q=deque()
    q.append([start,end])
    map[start][end]=0
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and map[nx][ny]>p:
                q.append([nx,ny])
                map[nx][ny]=0
    return map
                
                
for i in range(0,101):
    count=0
    result=copy.deepcopy(graph)
    for j in range(n):
        for k in range(n):
            if result[j][k]>i:
                result=bfs(result,j,k,i)
                count+=1
    mx[i]=count
print(max(mx))
