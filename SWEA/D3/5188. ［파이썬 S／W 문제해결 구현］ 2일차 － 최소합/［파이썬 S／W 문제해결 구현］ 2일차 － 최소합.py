for case in range(int(input())):
    n=int(input())
    num=[]
    for _ in range(n):
        num.append(list(map(int,input().split())))
    for x in range(n):
        for y in range(n):
            if x==0 and y==0:
                continue
            elif x==0:
                num[x][y]+=num[x][y-1]
            elif y==0:
                num[x][y]+=num[x-1][y]
            else:
                num[x][y]+=min(num[x-1][y],num[x][y-1])
    print(f'#{case+1} {num[n-1][n-1]}')