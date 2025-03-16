import sys
input=sys.stdin.readline

n=int(input())
num=[]

for _ in range(n):
    num.append(int(input()))
num.sort()
for i in range(n):
    print(num[i])