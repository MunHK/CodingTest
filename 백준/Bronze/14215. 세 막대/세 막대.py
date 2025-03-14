import sys
input=sys.stdin.readline
num=list(map(int,input().split()))
num.sort()
if num[0]+num[1]>num[2]:
  print(sum(num))
else:
  print(num[0]*2+num[1]*2-1)