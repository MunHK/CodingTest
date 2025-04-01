n=int(input())
num=[0,1,1,2,3]*91
for i in range(5,n+1):
    num[i]=num[i-1]*2-num[i-3]
print(num[n])