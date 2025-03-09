import sys

input=sys.stdin.readline

n,m=map(int,input().split())
ball=[0]*(n+1)
for _ in range(m):
  i,j,k=map(int,input().split())
  for a in range(i,j+1):
    ball[a]=k
for result in ball[1:]:
  print(result,end=' ')