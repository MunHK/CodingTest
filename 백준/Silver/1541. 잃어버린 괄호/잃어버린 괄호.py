import sys
input=sys.stdin.readline
num=list(map(str,input().split('-')))
for i in range(len(num)):
    if '+' in num[i]:
        a=list(map(int,num[i].split('+')))
        num[i]=str(sum(a))
result=int(num[0])
for i in num[1::]:
    result-=int(i)
print(result)