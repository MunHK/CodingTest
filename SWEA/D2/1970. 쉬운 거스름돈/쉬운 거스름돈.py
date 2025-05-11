money=[50000,10000,5000,1000,500,100,50,10]
for case in range(1,int(input())+1):
    print('#'+str(case))
    n=int(input())
    for i in range(8):
        if n>=money[i]:
            print(n//money[i],end=' ')
            n%=money[i]
        else:
            print(0,end=' ')
    print()
