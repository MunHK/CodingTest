n,k=map(int,input().split())
num=[i for i in range(1,n+1)]
cnt=k-1
result=[]
while True:
    result.append(num[cnt])
    num.remove(num[cnt])
    if len(num)==0:
        break
    cnt=(cnt+k-1)%len(num)
print('<',end='')
for i in range(n-1):
    print(result[i],end=', ')
print(result[-1],end='>')