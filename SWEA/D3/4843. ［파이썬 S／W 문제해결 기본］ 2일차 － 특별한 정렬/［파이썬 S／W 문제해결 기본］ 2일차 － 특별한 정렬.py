for case in range(int(input())):
    n=int(input())
    num=list(map(int,input().split()))
    num.sort(reverse=True)
    print('#'+str(case+1),end=' ')
    for i in range(1,11):
        if i%2==1:
            print(num[i//2],end=' ')
        elif i%2==0:
            print(num[-i//2],end=' ')
    print()