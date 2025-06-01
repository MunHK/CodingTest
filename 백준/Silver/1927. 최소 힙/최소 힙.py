import heapq
import sys
input=sys.stdin.readline
q=[]
n=int(input())
for _ in range(n):
    a=int(input())
    if a!=0:
        heapq.heappush(q,a)
    else:
        if q:
            print(heapq.heappop(q))
        else:
            print(0)