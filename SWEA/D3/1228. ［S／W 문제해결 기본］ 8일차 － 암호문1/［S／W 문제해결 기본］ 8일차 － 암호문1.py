for case in range(1,11):
    n=int(input())
    num=list(map(int,input().split()))
    m=int(input())
    c=list(map(str,input().split('I')))
    for i in c[1::]:
        cmd=list(map(int,i.split()))
        for j in range(cmd[1]):
            num.insert(cmd[0]+j,cmd[2+j])
    print('#'+str(case),end=' ')
    print(*num[:10:])

