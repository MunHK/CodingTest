n=int(input())
graph=[]
for _ in range(n):
    graph.append(list(map(int,input())))

def dfs(x,y):
    global count
    count+=1
    graph[x][y]=0
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or nx>=n or ny<0 or ny>=n:
            continue
        if graph[nx][ny]==1:
            dfs(nx,ny)

count=0
result=[]
for i in range(n):
    for j in range(n):
        if graph[i][j]==1:
            dfs(i,j)
            result.append(count)
            count=0
result.sort()
print(len(result))
for i in result:
    print(i)
