import sys

input=sys.stdin.readline

cnt=[0]*42
result=0

for _ in range(10):
  n=int(input())
  cnt[n%42]+=1

for i in range(42):
  if cnt[i]>0:
    result+=1
print(result)