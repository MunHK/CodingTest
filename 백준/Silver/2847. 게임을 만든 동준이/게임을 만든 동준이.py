n=int(input())
num=[]
result=0
for _ in range(n):
    num.append(int(input()))

for i in range(n-1,0,-1):
    if num[i]<=num[i-1]:
        result+=num[i-1]-num[i]+1
        num[i-1]=num[i]-1
print(result)

