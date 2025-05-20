for case in range(int(input())):
    n,a,b=map(int,input().split())
    num=[[1,n,0],[1,n,0]]
    print('#'+str(case+1),end=' ')
    while True:
        num[0][2]=(num[0][0]+num[0][1])//2
        num[1][2]=(num[1][0]+num[1][1])//2
        if num[0][2]==a and num[1][2]==b:
            print(0)
            break
        elif num[0][2]==a:
            print('A')
            break
        elif num[1][2]==b:
            print('B')
            break
        if num[0][2]>a:
            num[0][1]=(num[0][0]+num[0][1])//2
        else:
            num[0][0]=(num[0][0]+num[0][1])//2
        if num[1][2]>b:
            num[1][1]=(num[1][0]+num[1][1])//2
        else:
            num[1][0]=(num[1][0]+num[1][1])//2
