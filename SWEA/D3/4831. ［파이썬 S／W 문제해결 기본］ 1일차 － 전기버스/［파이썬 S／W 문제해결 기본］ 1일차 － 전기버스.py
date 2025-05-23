for case in range(int(input())):
    k,n,m=map(int,input().split())
    num=list(map(int,input().split()))
    current,cnt=0,0
    
    while current+k<n:
        for i in range(k,0,-1):
            if current+i in num:
                current+=i
                cnt+=1
                break
        else:
            cnt=0
            break
    print(f'#{case+1} {cnt}')

