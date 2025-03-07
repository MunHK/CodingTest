import sys
input=sys.stdin.readline

result=int(input())
n=int(input())
num=0
for _ in range(n):
    a,b=map(int,input().split())
    num+=a*b
print('Yes') if result==num else print('No')
