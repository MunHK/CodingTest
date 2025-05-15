n,m=map(int,input().split())

arr=[0]*m

def btk(k):
    if k==m:
        print(*arr)
        return
    for i in range(1,n+1):
        if k==0 or i>=arr[k-1]:
            arr[k] = i
            btk(k + 1)
btk(0)