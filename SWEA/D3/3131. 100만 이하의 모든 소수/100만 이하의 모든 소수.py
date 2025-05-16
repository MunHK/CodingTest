num=[True]*1000001
for i in range(2,int(1000000**0.5)+1):
    for j in range(i*2,1000001,i):
        if num[j]:
            num[j]=False
for i in range(2,1000001):
    if num[i]:
        print(i,end=' ')