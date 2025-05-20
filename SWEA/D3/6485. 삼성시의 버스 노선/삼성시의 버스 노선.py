for case in range(int(input())):
    n=int(input())
    route=[0]*5001
    num=[]
    for _ in range(n):
        a,b=map(int,input().split())
        for i in range(a,b+1):
            route[i]+=1
    p=int(input())
    print('#'+str(case+1),end=' ')
    for _ in range(p):
        print(route[int(input())],end=' ')
    print()
