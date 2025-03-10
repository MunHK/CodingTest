import sys
input=sys.stdin.readline
w=[1,1,2,2,2,8]
n=list(map(int,input().split()))
for i,j in zip(w,n):
  print(i-j,end=' ')