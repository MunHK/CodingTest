n=int(input())
pack=[0]+list(map(int,input().split()))
num=pack
for i in range(1,n+1):
    for j in range(1,i+1): #i=4 j=1,2,3,4
        num[i]=max(num[i],num[i-j]+pack[j])
print(num[n])