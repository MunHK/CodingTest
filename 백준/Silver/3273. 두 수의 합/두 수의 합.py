import sys
input=sys.stdin.readline

n=int(input())
num=list(map(int,input().split()))
x=int(input())
result=0
num.sort()
j=1
for i in range(n):
    while i+j<n:
        if num[i]+num[-j]<x:
            break
        if num[i]+num[-j]==x:
            result+=1
            j+=1
            break
        else:
            j+=1
print(result)