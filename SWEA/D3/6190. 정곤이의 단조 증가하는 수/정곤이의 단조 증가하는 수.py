for case in range(1,int(input())+1):
    n=int(input())
    num=list(map(int,input().split()))
    arr=[0]*2
    result=-1
    def btk(start,k):
        global result
        if k==2:
            a=list(map(int,str(num[arr[0]]*num[arr[1]])))
            for i in range(len(a)-1):
                if a[i]>a[i+1]:
                    return
            result=max(result,num[arr[0]]*num[arr[1]])
            return
        for i in range(start,n):
            arr[k]=i
            btk(i+1,k+1)
    btk(0,0)
    print(f'#{case} {result}')
