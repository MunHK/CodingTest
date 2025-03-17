import sys
input=sys.stdin.readline
n=int(input())
word=[]
for _ in range(n):
    word.append(input().split())
for i in sorted(word,key=lambda x:int(x[0])):
    print(*i)