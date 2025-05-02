from collections import deque
n=int(input())
graph=[[] for _ in range(n+1)]
result=[]
while True:
    a,b=map(int,input().split())
    if a==-1 and b==-1:
        break
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    q=deque()
    q.append(start)
    visited[start]=1
    while q:
        v=q.popleft()
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i]=visited[v]+1


for i in range(1,n+1):
    visited=[0]*(n+1)
    bfs(i)
    result.append(max(visited)-1)

mn=min(result)
print(mn,result.count(mn))
for i in range(1,n+1):
    if mn==result[i-1]:
        print(i,end=' ')


