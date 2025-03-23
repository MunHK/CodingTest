import sys
input=sys.stdin.readline
n=int(input())
cnt=0
num=[]
innum=[]
result=[]

for _ in range(n):
    num.append(int(input()))

for i in range(1,n+1):
    innum.append(i)
    result.append('+')
    while innum[-1]==num[cnt]:
        result.append('-')
        innum.pop()
        cnt+=1
        if len(innum)==0:
            break

if len(innum)==0:
    print('\n'.join(result))
else:
    print('NO')