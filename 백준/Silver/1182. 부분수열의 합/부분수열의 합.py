n,m=map(int,input().split())
num=list(map(int,input().split()))
visited=[False]*(n+1)
result=0
def btk(start,k,l):
    global result
    if k==l:
        if sum(arr)==m:
            result+=1
        return
    for i in range(start,n+1):
        arr[k]=num[i-1]
        btk(i+1,k+1,l)

for i in range(1,n+1):
    arr = [0] * i
    btk(1,0,i)
print(result)