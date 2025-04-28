n=int(input())

rgb_graph=[]
rb_graph=[]
for _ in range(n):
    word=input()
    rgb_graph.append(list(map(str,word)))
    rb_graph.append(list(map(str,word.replace('G','R'))))

def bfs(graph,start,end):
    q=[[start,end]]
    rgb=graph[start][end] #R,G,B
    graph[start][end]='O'
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    while q:    
        x,y=q.pop(0)
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny]==rgb:
                q.append([nx,ny])
                graph[nx][ny]='O'

count=[0,0]
for i in range(n):
    for j in range(n):
        if rgb_graph[i][j]!='O':
            bfs(rgb_graph,i,j)
            count[0]+=1
        if rb_graph[i][j]!='O':
            bfs(rb_graph,i,j)
            count[1]+=1
print(*count)
