for case in range(1,11):
    int(input())
    graph=[]
    mx=0
    for _ in range(100):
        a=list(map(int,input().split()))
        graph.append(a)
        mx=max(mx,sum(a))

    for i in range(100):
        b=0
        for j in range(100):
            b+=graph[j][i]
        mx=max(mx,b)
    b = 0
    for i in range(100):
        b+=graph[i][i]
        mx=max(mx,b)
    b = 0
    for i in range(99,-1,-1):
        b+=graph[i][i]
        mx=max(mx,b)
    print(f'#{case} {mx}')

