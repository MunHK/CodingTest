for case in range(1,11):
    int(input())
    red=False
    blue=False
    result=0
    graph=[]
    for _ in range(100):
        graph.append(list(map(int,input().split())))
    for i in range(100):
        red=False
        blue=False
        for j in range(100):
            if graph[j][i]==1:
                red=True
            if graph[j][i]==2 and red:
                blue=True
            if red:
                if blue:
                    result+=1
                    red=False
                    blue=False
    print(f'#{case} {result}')