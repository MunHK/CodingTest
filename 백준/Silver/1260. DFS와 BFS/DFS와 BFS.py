from collections import deque
import sys

input=sys.stdin.readline

n,m,v=map(int,input().split())

graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()
    
def dfs(graph,v,visited):
    visited[v]=True
    print(v,end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)


def bfs(graph,start,visited):
    queue=deque([start])
    visited[start]=True
    while queue:
        v=queue.popleft()
        print(v,end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True

dfs(graph,v,visited)
print()
visited=[False]*(n+1)
bfs(graph,v,visited)