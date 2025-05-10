for case in range(1,11):
    n=int(input())
    graph=[]
    dgraph=[]
    result=0
    for _ in range(8):
        graph.append(list(map(str,input())))
        dgraph.append([])

    for i in range(8):
        for j in range(8):
            dgraph[i].append(graph[j][i])

    for i in range(8):
        for j in range(9-n):
            word=graph[i][j:j+n]
            dword=dgraph[i][j:j+n]
            if n%2==0:
                if word[:n//2]==word[-1:n//2-1:-1]:
                    result+=1
                if dword[:n//2]==dword[-1:n//2-1:-1]:
                    result+=1
            else:
                if word[:n//2]==word[-1:n//2:-1]:
                    result+=1
                if dword[:n//2]==dword[-1:n//2:-1]:
                    result+=1
    print(f'#{case} {result}')