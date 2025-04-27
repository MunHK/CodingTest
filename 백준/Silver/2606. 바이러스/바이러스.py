n=int(input())
m=int(input())

graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    global count
    visited[v]=True
    
    graph[v].sort()
    for i in graph[v]:
        if not visited[i]:
            count+=1
            dfs(i)

count=0
dfs(1)
print(count)
