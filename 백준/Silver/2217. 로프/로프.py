import sys
input=sys.stdin.readline
n=int(input())
num=[]
result=[]
for _ in range(n):
    num.append(int(input()))

num.sort()
for i in range(0,n):
    result.append(num[i]*(n-i))
print(max(result))

    