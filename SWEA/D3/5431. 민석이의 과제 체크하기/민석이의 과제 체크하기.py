for case in range(1,int(input())+1):
    n,k=map(int,input().split())
    st=[i for i in range(1,n+1)]
    num=list(map(int,input().split()))
    print('#'+str(case),end=' ')
    for i in st:
        if i not in num:
            print(i,end=' ')
    print()