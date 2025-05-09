for case in range(1,11):
    n=int(input())
    dump=list(map(int,input().split()))
    for i in range(n):
        mx=max(dump)
        mn=min(dump)
        dump[dump.index(mx)]-=1
        dump[dump.index(mn)]+=1
    print(f'#{case} {max(dump)-min(dump)}')