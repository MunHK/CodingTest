n,m=map(int,input().split())

arr=[0]*m

def btk(start,k):
    if k==m:
        print(*arr)
        return
    for i in range(start,n+1):
        arr[k]=i
        btk(i+1,k+1)
btk(1,0)