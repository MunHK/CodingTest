for case in range(1,int(input())+1):
    n=int(input())
    speed,result=0,0
    for i in range(n):
        num=list(map(int,input().split()))
        if num[0]==1:
            speed+=num[1]
        elif num[0]==2:
            speed-=num[1] if speed-num[1]>=0 else 0
        result+=speed
    print(f'#{case} {result}')