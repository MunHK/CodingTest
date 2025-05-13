for case in range(1,int(input())+1):
    num=list(map(int,input().split()))
    a=num[0]*60+num[1]+num[2]*60+num[3]
    print(f'#{case} {a//60%12 if a//60%12!=0 else 12} {a%60}')