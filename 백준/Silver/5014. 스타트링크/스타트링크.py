from collections import deque

f,s,g,u,d=map(int,input().split())
graph=[0]*(f+1)
visited=[False]*(f+1)

def bfs():
    q=deque()
    q.append(s)
    visited[s]=True
    while q:
        v=q.popleft()
        if v==g:
            break
        for nv in (v+u,v-d):
            if 0<nv<=f and not visited[nv]:
                q.append(nv)
                graph[nv]=graph[v]+1
                visited[nv]=True
bfs()
if visited[g]:
    print(graph[g])
else:
    print('use the stairs')