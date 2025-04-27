n=int(input())
x,y=map(int,input().split())
case=int(input())

graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)
result=[]
for _ in range(case):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v,count):
    visited[v]=True
    if y==v:
        result.append(count)
    for i in graph[v]:
        if not visited[i]:
            dfs(i,count+1)

dfs(x,0)
print(result[0] if len(result)!=0 else -1)
