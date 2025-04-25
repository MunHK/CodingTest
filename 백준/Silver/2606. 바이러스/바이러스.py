import sys
input=sys.stdin.readline

n=int(input())
m=int(input())
cnt=0

graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,n+1):
    graph[i].sort()

def dfs(graph,v,visited):
    visited[v]=True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)
dfs(graph,1,visited)
print(sum([1 for i in visited if i])-1)