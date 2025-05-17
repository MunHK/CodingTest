import sys
input=sys.stdin.readline

n,m=map(int,input().split())
num=list(map(int,input().split()))
dp=[0]*n
dp[0]=num[0]
for i in range(1,n):
    dp[i]=num[i]+dp[i-1]

for _ in range(m):
    a,b=map(int,input().split())
    if a!=1:
        print(dp[b-1]-dp[a-2])
    else:
        print(dp[b-1])