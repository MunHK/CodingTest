for case in range(1,int(input())+1):
    p,q,r,s,w=map(int,input().split())
    a=w*p
    if w<=r:
        b=q
    else:
        b=q+(w-r)*s
    print(f'#{case} {min(a,b)}')