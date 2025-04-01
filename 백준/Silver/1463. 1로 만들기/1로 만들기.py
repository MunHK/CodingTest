x=int(input())
n=[0]*(x+1)
for i in range(2,x+1):
    n[i]=n[i-1]+1
    if i%3==0:
        n[i]=min(n[i],n[i//3]+1)
    if i%2==0:
        n[i]=min(n[i],n[i//2]+1)
print(n[x])
