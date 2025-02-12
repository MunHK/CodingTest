n,m = map(int,input().split())

result=[True]*(m+1)
result[1]=False
for i in range(2,int(m**0.5)+1):
    if result:
        for j in range(i*2,m+1,i):
            result[j]=False

for k in range(n,m+1):
    if result[k]:
        print(k)
