for t in range(int(input())):
    n=int(input())
    num=[]
    result90=[[0]*n for _ in range(n)]
    result180=[[0]*n for _ in range(n)]
    result270=[[0]*n for _ in range(n)]
    for _ in range(n):
        num.append(list(map(int,input().split())))

    for i in range(n):
        for j in range(n):
            result90[j][n-1-i]=num[i][j]

    for i in range(n):
        for j in range(n):
            result180[j][n-1-i]=result90[i][j]

    for i in range(n):
        for j in range(n):
            result270[j][n-1-i]=result180[i][j]

    print(f'#{t+1}')
    for i in range(n):
        print(*result90[i],sep='',end=' ')
        print(*result180[i],sep='',end=' ')
        print(*result270[i],sep='')
    