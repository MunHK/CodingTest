for case in range(1,int(input())+1):
    n,l=map(int,input().split())
    ham=[[0,0]]
    dp=[[0]*(l+1) for _ in range(n+1)]
    result=0
    for _ in range(n):
        ham.append(list(map(int,input().split())))

    for i in range(1,n+1):
        for j in range(1,l+1):
            if ham[i][1]<=j:
                dp[i][j]=max(dp[i-1][j],ham[i][0]+dp[i-1][j-ham[i][1]])
            else:
                dp[i][j]=dp[i-1][j]
        result=max(dp[i])
    print(f'#{case} {result}')
