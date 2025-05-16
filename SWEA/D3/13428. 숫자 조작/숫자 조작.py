for case in range(1,int(input())+1):
    n=list(map(str,input()))
    arr=[0]*2
    result=[int(''.join(n))]
    def btk(start,k):
        if k==2:
            n[arr[0]],n[arr[1]]=n[arr[1]],n[arr[0]]
            if n[0]!='0':
                result.append(int(''.join(n)))
            n[arr[0]],n[arr[1]]=n[arr[1]],n[arr[0]]
            return
        for i in range(start,len(n)):
            arr[k]=i
            btk(i+1,k+1)
    btk(0,0)
    print(f'#{case} {min(result)} {max(result)}')