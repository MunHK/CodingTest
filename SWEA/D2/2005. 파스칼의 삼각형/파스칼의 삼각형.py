t=int(input())
for case in range(1,t+1):
    n=int(input())
    tri=[[1]*i for i in range(1,n+1)]
    for i in range(n):
        for j in range(i):
            if j<=0 or j>=n-1:
                tri[i][j]=1
            else:
                tri[i][j]=tri[i-1][j-1]+tri[i-1][j]
    print(f'#{case}')
    for i in tri:
        print(*i)