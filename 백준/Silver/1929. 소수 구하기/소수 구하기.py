max=1000000
num=[i for i in range(max+1)]
num[1]=0
for i in range(2,int(max**0.5)+1):
    if num!=0:
        j=2
        while i*j<=max:
            num[i*j]=0
            j+=1

n,m = map(int,input().split())
for i in range(n,m+1):
    if num[i]:
        print(num[i])