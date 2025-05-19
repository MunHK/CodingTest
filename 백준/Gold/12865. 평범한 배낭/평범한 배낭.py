import sys
input=sys.stdin.readline

n,k=map(int,input().split())
bag=[[0,0]]
result=0
dp=[[0]*(k+1) for _ in range(n+1)]
for _ in range(n):# a=무게 b=가치
    a,b=map(int,input().split())
    bag.append([a,b])

for i in range(1,n+1):
    for j in range(1,k+1):
        if bag[i][0]<=j:
            dp[i][j]=max(dp[i-1][j],bag[i][1]+dp[i-1][j-bag[i][0]])
        else:
            dp[i][j]=dp[i-1][j]
    result=max(dp[i])
print(result)


