import sys
input=sys.stdin.readline

n=int(input())
num=[]
result=0
start=0
for _ in range(n):
    num.append(list(map(int,input().split())))
num.sort()
num.sort(key=lambda x:x[1])
for i in num:
    if i[0]>=start:
        start=i[1]
        result+=1
print(result)