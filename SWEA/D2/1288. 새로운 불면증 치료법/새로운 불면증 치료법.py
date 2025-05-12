for case in range(1,int(input())+1):
    visit=[False]*10
    n=int(input())
    i=1
    while True:
        num=list(map(int,str(i*n)))
        for j in num:
            if visit[j]==False:
                visit[j]=True
        if False not in visit:
            break
        i+=1
    print(f'#{case} {i*n}')