num=[0,31,28,31,30,31,30,31,31,30,31,30,31]
for case in range(1,int(input())+1):
    result=0
    day=list(map(int,input().split()))
    if day[0]==day[2]:
        result+=day[3]-day[1]+1

    if day[0]<day[2]:
        result+=num[day[0]]-day[1]+1
        for i in range(day[0]+1,day[2]):
            result+=num[i]
        result+=day[3]
    print(f'#{case} {result}')