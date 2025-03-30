import sys
input=sys.stdin.readline
n=[True]*1000001
for i in range(2,int(1000001**0.5)+1):
    if n[i]:
        for j in range(i*i,1000001,i):
            n[j]=False

t=int(input())
for _ in range(t):
    result=0
    num=int(input())
    for k in range(2,num//2+1):
        if n[k] and n[num-k]:
            result+=1
    print(result)