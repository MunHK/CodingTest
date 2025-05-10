t=int(input())
for case in range(1,t+1):
    n,m=map(int,input().split())
    if n>m:
        n,m=m,n
        mum = list(map(int, input().split()))
        num = list(map(int, input().split()))
    else:
        num = list(map(int, input().split()))
        mum = list(map(int, input().split()))
    mx=0
    for i in range(m-n+1):
        s=0
        for j in range(n):
            s+=num[j]*mum[j+i]
        mx=max(mx,s)
    print(f'#{case} {mx}')