for case in range(1,int(input())+1):
    n=int(input())
    result=[2,3,5,7,11]
    print('#'+str(case),end=' ')
    for i in result:
        a=0
        while n%i==0:
            a+=1
            n//=i
        print(a,end=' ')
    print()