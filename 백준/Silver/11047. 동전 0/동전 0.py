import sys
input=sys.stdin.readline
n,k=map(int,input().split())
num=[]
result=0
for _ in range(n):
    a=int(input())
    num.append(a)
for i in num[::-1]:
    result=result+k//i
    k%=i
print(result)