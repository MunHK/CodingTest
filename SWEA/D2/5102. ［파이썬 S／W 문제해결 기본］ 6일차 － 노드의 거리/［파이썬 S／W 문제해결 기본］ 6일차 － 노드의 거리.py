from collections import deque
def bfs(start):
    q=deque()
    q.append(start)
    while q:
        v=q.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i]=visited[v]+1
                q.append(i)

for case in range(int(input())):
    v,e=map(int,input().split())
    graph=[[] for _ in range(v+1)]
    visited=[0]*(v+1)
    for _ in range(e):
        a,b=map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    a,b=map(int,input().split())

    bfs(a)
    print(f'#{case+1} {visited[b]}')