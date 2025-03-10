import sys
input=sys.stdin.readline
n=int(input())
for i in range(1,n):
  print(' '*(n-i)+'*'*(i*2-1))
for j in range(n,0,-1):
  print(' '*(n-j)+'*'*(j*2-1))
