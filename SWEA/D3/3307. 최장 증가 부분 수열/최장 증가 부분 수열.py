for case in range(int(input())):
    n=int(input())
    num=list(map(int,input().split()))
    dp=[1]*n
    
    for i in range(n):
        for j in range(i):
            if num[i]>num[j]:
                dp[i]=max(dp[j]+1,dp[i])
    print(f'#{case+1} {max(dp)}')