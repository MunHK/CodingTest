from collections import deque
for case in range(1,11):
    int(input())
    num=deque()
    a=list(map(int,input().split()))

    for i in a:
        num.append(i)
    while num[-1]!=0:
        for i in range(1,6):
            q=num.popleft()
            if q-i<=0:
                num.append(0)
                break
            num.append(q-i)
    print(f'#{case}', end=' ')
    print(*num)