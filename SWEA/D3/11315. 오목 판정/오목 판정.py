for case in range(int(input())):
    n=int(input())
    graph=[]
    opgraph=[]
    for _ in range(n):
        a=list(map(str,input()))
        graph.append(a)
        opgraph.append(a[::-1])
    chgraph=list(map(list,zip(*graph)))
    result='NO'

    for i in range(n):
        if 'ooooo' in ''.join(graph[i]) or 'ooooo' in ''.join(chgraph[i]):
            result='YES'
            break

    for i in range(n):
        tdchk=[]
        lrchk=[]
        otdchk=[]
        olrchk=[]
        for j in range(n-i):
            tdchk.append(graph[i+j][j])
            lrchk.append(graph[j][i+j])
            otdchk.append(opgraph[i+j][j])
            olrchk.append(opgraph[j][i+j])
        if 'ooooo' in ''.join(tdchk) or 'ooooo' in ''.join(lrchk) or 'ooooo' in ''.join(otdchk) or 'ooooo' in ''.join(olrchk):
            result='YES'
            break
    print(f'#{case+1} {result}')