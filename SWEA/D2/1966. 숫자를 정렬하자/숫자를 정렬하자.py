for case in range(1,int(input())+1):
    int(input())
    num=list(map(int,input().split()))
    print(f'#{case}',end=' ')
    print(*sorted(num))