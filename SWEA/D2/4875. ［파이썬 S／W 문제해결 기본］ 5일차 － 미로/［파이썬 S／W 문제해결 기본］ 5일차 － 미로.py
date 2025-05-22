from collections import deque
dx=[1,-1,0,0]
dy=[0,0,1,-1]
def bfs(x,y):
    q=deque()
    q.append([x,y])
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if graph[nx][ny]!=1:
                    graph[nx][ny]=1
                    q.append([nx,ny])
for case in range(int(input())):
    n=int(input())
    graph=[]
    startx,starty,endx,endy=0,0,0,0
    for i in range(n):
        num=list(map(int,input()))
        if 2 in num:
            starty=num.index(2)
            startx=i
        if 3 in num:
            endy=num.index(3)
            endx=i
        graph.append(num)
    bfs(startx,starty)
    print('#'+str(case+1),end=' ')
    print(1) if graph[endx][endy]==1 else print(0)