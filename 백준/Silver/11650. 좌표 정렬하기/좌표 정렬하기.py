import sys
input=sys.stdin.readline
n=int(input())

num=[]
for _ in range(n):
    a,b=map(int,input().split())
    num.append([a,b])
num.sort()
for i in range(n):
    print(num[i][0],num[i][1])