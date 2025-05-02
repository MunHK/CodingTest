import sys
input=sys.stdin.readline

n=int(input())
num=list(map(int,input().split()))
result=0

num.sort()
for i in range(n):
    result+=num[i]*(n-i)
print(result)