from collections import deque

n=int(input())
m=int(input())
graph=[[] for _ in range(n+1)]
visited=[0]*(n+1)
count=0

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    q=deque([start])
    visited[start]=1
    while q:
        v=q.popleft()
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i]=visited[v]+1

bfs(1)
for i in range(2,n+1):
    if 0<visited[i]<=3:
        count+=1
print(count)