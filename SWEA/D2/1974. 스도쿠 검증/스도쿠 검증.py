t=int(input())
for case in range(1,t+1):
    graph=[]
    su=1
    for _ in range(9):
        graph.append(list(map(int,input().split())))
    
    for i in graph:
        if len(set(i))!=9:
            su=0
    
    for i in range(3):
        for j in range(3):
            l = []
            for k in range(3):
                for n in range(3):
                    l.append(graph[i*3+k][j*3+n])
            if len(set(l)) != 9:
                su = 0
    
    for i in range(9):
        l=[]
        for j in range(9):
            l.append(graph[j][i])
        if len(set(l)) != 9:
            su = 0
    print(f'#{case} {su}')