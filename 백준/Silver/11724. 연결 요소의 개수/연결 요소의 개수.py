import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    q=deque()
    q.append(start)
    while q:
        v=q.popleft()
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i]=True

count=0
for i in range(1,n+1):
    if not visited[i]:
        bfs(i)
        count+=1
print(count)
