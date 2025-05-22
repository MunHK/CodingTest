from collections import deque
for case in range(int(input())):
    n,m=map(int,input().split())
    result=deque()
    result.append(str(n))
    def btk(start,k):
        if k==2:
            num[arr[0]],num[arr[1]]=num[arr[1]],num[arr[0]]
            result.append(''.join(num))
            num[arr[0]], num[arr[1]] = num[arr[1]], num[arr[0]]
            return
        for i in range(start,len(str(n))):
            arr[k]=i
            btk(i+1,k+1)

    for i in range(m):
        result=deque(set(result))
        for _ in range(len(result)):
            num=list(map(str,result[0]))
            arr=[0]*2
            btk(0,0)
            result.popleft()
    print(f'#{case+1} {max(result)}')