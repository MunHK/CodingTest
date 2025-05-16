for case in range(1,int(input())+1):
    n,q=map(int,input().split())
    num=[0]*n
    for i in range(q):
        a,b=map(int,input().split())
        num[a-1:b]=[i+1]*(b-a+1)
    print('#'+str(case),end=' ')
    print(*num)