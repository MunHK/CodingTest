import queue
import sys
input=sys.stdin.readline
que=queue.deque()
n=int(input())

for _ in range(n):
    co=list(map(str,input().split()))
    if co[0]=='push_front':
        que.insert(0,co[1])
    elif co[0]=='push_back':
        que.insert(len(que),co[1])
    elif co[0]=='pop_front':
        print(que.popleft()) if que else print(-1)
    elif co[0]=='pop_back':
        print(que.pop()) if que else print(-1)
    elif co[0]=='size':
        print(len(que))
    elif co[0]=='empty':
        print(0) if que else print(1)
    elif co[0]=='front':
        print(que[0]) if que else print(-1)
    elif co[0]=='back':
        print(que[-1]) if que else print(-1)
