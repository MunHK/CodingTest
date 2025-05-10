t=int(input())
for case in range(1,t+1):
    n=int(input())
    graph=[]
    result=0
    for _ in range(n):
        graph.append(list(map(int,input())))

    for i in range(n):
        if i <= n // 2:
            result+=sum(graph[i][n // 2 - i:n // 2 + i + 1])
        else:
            result+=sum(graph[i][i - n // 2:n + n // 2 - i])
    print(f'#{case} {result}')