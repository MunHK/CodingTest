for test_case in range(int(input())):
    n,m=map(int,input().split())
    result=[]
    if n<m:
        nnum=list(map(int,input().split()))
        mnum=list(map(int,input().split()))
    else:
        n,m=m,n
        mnum=list(map(int,input().split()))
        nnum=list(map(int,input().split()))

    for k in range(m-n+1):
        hap=0
        for i in range(n):
            hap+=nnum[i]*mnum[i+k]
        result.append(hap)
    print(f'#{test_case+1} {max(result)}')