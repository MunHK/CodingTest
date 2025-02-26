import sys
input = sys.stdin.readline

n=int(input())
for i in range(n):
    result=list(map(str,input().split()))
    reverse=[]
    for i in result:
        reverse.append(i[::-1])
    print(' '.join(reverse))