for case in range(int(input())):
    n,m=map(int,input().split())
    result=0
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    a.sort()
    for i in b:
        l, r = 0, n-1
        m = (l + r) // 2
        bol = ''
        if i in a:
            while a[m]!=i:
                if i>a[m]:
                    l=m+1
                    m = (l + r) // 2
                    if bol=='right':
                        break
                    bol='right'
                elif i<a[m]:
                    r=m-1
                    m = (l + r) // 2
                    if bol=='left':
                        break
                    bol='left'
            else:
                result+=1
    print(f'#{case+1} {result}')