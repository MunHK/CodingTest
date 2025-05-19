for case in range(1,int(input())+1):
    n,m,k=map(int,input().split()) #n=사람수 m=시간 k=붕어빵개수
    made=0
    es=False
    num=list(map(int,input().split()))
    num.sort(reverse=True)
    result='Impossible'
    for i in range(1,max(num)+1):
        if i%m==0:
            made+=k
        while num and num[-1]==i:
            if made<=0:
                es=True
                break
            made-=1
            num.pop()
        if es:
            break
    else:
        if not num:
            result='Possible'
    print(f'#{case} {result}')