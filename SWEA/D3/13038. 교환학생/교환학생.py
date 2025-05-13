def md(day,num):
    result=0
    while day!=0:
        for i in num:
            if day == 0:
                break
            if i==1:
                day-=1
            result+=1
    return result
            
for case in range(1,int(input())+1):
    day=int(input())
    result=[]
    num=list(map(int,input().split()))
    for i in range(7):
        num.append(num.pop(0))
        result.append(md(day,num))
    print(f'#{case} {min(result)}')