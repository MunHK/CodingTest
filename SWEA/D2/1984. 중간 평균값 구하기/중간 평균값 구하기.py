for case in range(1,int(input())+1):
    num=list(map(int,input().split()))
    num.sort()
    s=sum(num[1:-1:])/8
    if s>=int(s)+0.5:
        s+=1
    print(f'#{case} {int(s)}')