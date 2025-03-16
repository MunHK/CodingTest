import sys
input=sys.stdin.readline

n,k=map(int,input().split())
num=list(map(int,input().split()))

num.sort()

print(num[-k])