for case in range(1,11):
    n=int(input())
    num=list(map(int,input().split()))
    m=int(input())
    com=list(map(str,input().split()))
    for i in range(m):
        if com[0]=='I':
            for j in range(int(com[2])):
                num.insert(int(com[1])+j,int(com[3+j]))
            com=com[int(com[2])+3::]
            continue
        elif com[0]=='D':
            num=num[:num[1]:]+num[num[1]+num[2]::]
            com=com[3::]
            continue
        elif com[0]=='A':
            for j in range(int(com[1])):
                num.append(int(com[2+j]))
            com=com[int(com[1])+2::]
            continue
    print(f'#{case}',end=' ')
    print(*num[:10])