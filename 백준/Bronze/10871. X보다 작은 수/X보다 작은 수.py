import sys

input=sys.stdin.readline

a,x=map(int,input().split())
num=list(map(int,input().split()))
for i in num:
  if i<x:
    print(i,end=' ')