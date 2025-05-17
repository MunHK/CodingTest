n=int(input())
dp=[0]*(n+1)
num=[0]*(n+1)
for i in range(1,n+1):
    num[i]=int(input())
if n>=3:
    dp[1]=num[1]
    dp[2]=num[2]
    dp[3]=num[3]
    for i in range(4,n+1):
        dp[i]=num[i]+min(dp[i-2],dp[i-3])
if n<3:
    print(sum(num))
else:
    print(sum(num)-min(dp[n-1],dp[n-2]))
