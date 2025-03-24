import sys
input=sys.stdin.readline
n=int(input())
que=[]
for _ in range(n):
    co=list(map(str,input().split()))
    if co[0]=='push':
        que.append(co[1])
    elif co[0]=='pop':
        if que:
            print(que[0])
            que.remove(que[0])
        else:
            print(-1)
    elif co[0]=='size':
        print(len(que))
    elif co[0]=='empty':
        print(0) if que else print(1)
    elif co[0]=='front':
        print(que[0]) if que else print(-1)
    elif co[0]=='back':
        print(que[-1]) if que else print(-1)