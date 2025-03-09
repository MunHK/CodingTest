import sys

input=sys.stdin.readline

n=int(input())
result=0
score=sorted(list(map(int,input().split())))
for i in score:
  result+=i/score[-1]*100
print(result/n)