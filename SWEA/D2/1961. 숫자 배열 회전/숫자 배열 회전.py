t=int(input())
for case in range(1,t+1):
    n=int(input())
    graph=[]
    result90=[]
    result180=[]
    result270=[]
    for _ in range(n):
        graph.append(list(map(int,input().split())))
        result90.append([0]*n)
        result180.append([0]*n)
        result270.append([0]*n)

    def rotate(a,b):
        for i in range(n):
            for j in range(n):
                a[j][n-i-1]=b[i][j]
        return a

    result90=rotate(result90,graph)
    result180=rotate(result180,result90)
    result270=rotate(result270,result180)

    print(f'#{case}')
    for i,j,k in zip(result90,result180,result270):
        print(*i,sep='',end=' ')
        print(*j,sep='',end=' ')
        print(*k,sep='')