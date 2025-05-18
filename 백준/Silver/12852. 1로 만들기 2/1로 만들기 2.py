import sys
input=sys.stdin.readline
n=int(input())
if n==1:
    print('0\n1')
    exit(0)
dp=[0]*(n+1)
road=[['1'] for _ in range(n+1)]
dp[2]=1
for i in range(2,n+1):
    mn=i-1
    dp[i]=dp[i-1]+1
    if i%3==0:
        if dp[i]>dp[i//3]+1:
            dp[i]=dp[i//3]+1
            mn=i//3
    if i%2==0:
        if dp[i]>dp[i//2]+1:
            dp[i]=dp[i//2]+1
            mn=i//2
    road[i]=[' '.join(road[mn])]
    road[i].append(str(i))
print(dp[n])
road[n]=[' '.join(road[n])]
print(*list(map(int,road[n][0].split()))[::-1])