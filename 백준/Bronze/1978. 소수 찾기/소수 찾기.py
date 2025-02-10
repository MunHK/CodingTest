n=int(input())
m=list(map(int,input().split()))
result=0
for i in m:
    if i==1:
        continue
    cnt=0
    for j in range(1,int(i**0.5)+1):
        if i%j==0:
            cnt+=1
    if cnt==1:
        result+=1
print(result)