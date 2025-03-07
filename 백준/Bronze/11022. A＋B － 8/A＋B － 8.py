import sys
input=sys.stdin.readline

n=int(input())
for test_case in range(1,n+1):
    a,b=map(int,input().split())
    print(f'Case #{test_case}: {a} + {b} = {a+b}')
