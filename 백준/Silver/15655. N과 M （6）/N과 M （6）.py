n,m=map(int,input().split())

num=list(map(int,input().split()))
arr=[0]*m
num.sort()
def btk(start,k):
    if k==m:
        print(*arr)
        return
    for i in range(start,n):
        arr[k]=num[i]
        btk(i+1,k+1)
btk(0,0)