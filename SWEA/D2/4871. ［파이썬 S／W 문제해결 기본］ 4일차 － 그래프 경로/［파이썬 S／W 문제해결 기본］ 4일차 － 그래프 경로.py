from collections import deque
def bfs(start):
    q=deque()
    q.append(start)
    visited[start]=True
    while q:
        v=q.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i]=True
                q.append(i)
for case in range(int(input())):
    v,e=map(int,input().split())
    graph=[[] for _ in range(v+1)]
    visited=[False]*(v+1)

    for _ in range(e):
        a,b=map(int,input().split())
        graph[a].append(b)

    s,g=map(int,input().split())
    bfs(s)
    print('#'+str(case+1),end=' ')
    print(1) if visited[g] else print(0)