for case in range(1,int(input())+1):
    n,k=map(int,input().split())
    num=list(map(int,input().split()))
    result=0
    def dfs(v,s):
        global result
        if s>=k:
            if s==k:
                result+=1
            return
        for i in range(v,n):
            dfs(i+1,s+num[i])
    dfs(0,0)
    print(f'#{case} {result}')