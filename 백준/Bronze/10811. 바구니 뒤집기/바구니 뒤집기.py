import sys

input=sys.stdin.readline

n,m=map(int,input().split())
bk=[i for i in range(1,n+1)]
for _ in range(m):
  i,j=map(int,input().split())
  for k in range((j-i+1)//2):
    bk[i+k-1],bk[j-k-1]=bk[j-k-1],bk[i+k-1]
print(*bk)