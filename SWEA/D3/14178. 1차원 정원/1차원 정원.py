for case in range(1,int(input())+1):
    n,d=map(int,input().split())
    result=0
    d=d*2+1
    if n%d>0:
        result=n//d+1
    else:
        result=n//d
    print(f'#{case} {result}')