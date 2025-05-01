import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline
n,m=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(v):
    visited[v]=True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)
    return True
count=0
for i in range(1,n+1):
    if not visited[i]:
        if dfs(i):
            count+=1
print(count)
