import sys

input=sys.stdin.readline

num=[0]*9
for i in range(9):
  num[i]=int(input())
max=max(num)
print(max)
print(num.index(max)+1)