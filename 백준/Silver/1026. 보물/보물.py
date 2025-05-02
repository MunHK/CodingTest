import sys
input=sys.stdin.readline
n=int(input())
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())),reverse=True)
result=0
for i,j in zip(a,b):
    result+=i*j
print(result)
    