for case in range(1,11):
    a,b=map(str,input().split())
    num=list(map(int,b))
    i=0
    while len(num)!=i+1:
        if num[i]==num[i+1]:
            num=num[:i:]+num[i+2::]
            i=0
            continue
        i+=1
    print('#'+str(case),end=' ')
    print(*num,sep='')