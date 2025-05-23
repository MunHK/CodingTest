for case in range(int(input())):
    n=int(input())
    cnt=0
    visited=[False]*n
    visited1=[False]*(n*2-1)
    visited2=[False]*(n*2-1)
    
    def btk(x):
        global cnt
        if x==n:
            cnt+=1
            return
        for y in range(n):
            if not visited[y] and not visited1[x+y] and not visited2[x-y+n-1]:
                visited[y]=True
                visited1[x+y]=True
                visited2[x-y+n-1]=True
                btk(x+1)
                visited[y]=False
                visited1[x+y]=False
                visited2[x-y+n-1]=False
    
    btk(0)
    print(f'#{case+1} {cnt}')