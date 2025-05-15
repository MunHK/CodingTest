n,m=map(int,input().split())

arr=[0]*m
visited=[False]*(n+1)

def btk(k):
    if k==m:
        print(*arr)
        return
    for i in range(1,n+1):
        if not visited[i]:
            arr[k]=i
            visited[i]=True
            btk(k+1)
            visited[i]=False
btk(0)