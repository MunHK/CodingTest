from collections import deque

n,k=map(int,input().split())
graph=[0]*100001
visited=[False]*100001

def bfs():
    q=deque([n])
    visited[n]=True
    while q:
        x=q.popleft()
        if x==k:
            break
        for i in (x+1,x-1,x*2):
            if 0<=i<100001 and not visited[i]:
                q.append(i)
                visited[i]=True
                graph[i]=graph[x]+1
bfs()
print(graph[k])
