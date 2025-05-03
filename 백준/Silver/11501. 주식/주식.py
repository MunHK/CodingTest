case=int(input())
for _ in range(case):
    int(input())
    num=list(map(int,input().split()))
    mx=num[-1]
    result=0
    for i in num[-2::-1]:
        if mx>i:
            result+=mx-i
        elif mx<i:
            mx=i
    print(result)
