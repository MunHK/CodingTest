import sys

input=sys.stdin.readline

num=[0]*9
for i in range(9):
  num[i]=int(input())
print(max(num))
print(num.index(max(num))+1)