n=int(input())

arr=[0]*n
visited1=[False]*n
visited2=[False]*(n*2-1)
visited3=[False]*(n*2-1)
cnt=0
def btk(x):
    global cnt
    if x==n:
        cnt+=1
        return
    for y in range(n):
        if not visited1[y] and not visited2[x+y] and not visited3[x-y+n-1]:
            arr[x]=[x,y]
            visited1[y]=True
            visited2[x+y]=True
            visited3[x-y+n-1]=True
            btk(x+1)
            visited1[y]=False
            visited2[x+y]=False
            visited3[x-y+n-1]=False
btk(0)#A1 A2 A3 A4
print(cnt)

