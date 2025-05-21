for case in range(int(input())):
    n,m=map(int,input().split())
    num=list(map(int,input().split()))
    result=[]
    for i in range(n-m+1):
        result.append(sum(num[i:i+m]))
    print(f'#{case+1} {max(result)-min(result)}')