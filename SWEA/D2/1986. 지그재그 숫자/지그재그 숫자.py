for case in range(1,int(input())+1):
    n=int(input())
    result=0
    for i in range(1,n+1):
        result=result+i if i%2==1 else result-i
    print(f'#{case} {result}')