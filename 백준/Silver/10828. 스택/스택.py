import sys
input=sys.stdin.readline
n=int(input())
com=[]
for _ in range(n):
    word=list(map(str,input().split()))
    if word[0]=='push':
        com.append(word[1])
    elif word[0]=='pop':
        if len(com)!=0:
            print(com.pop())
        else:
            print(-1)
    elif word[0]=='size':
        print(len(com))
    elif word[0]=='empty':
        print(1) if len(com)==0 else print(0)
    elif word[0]=='top':
        print(com[-1]) if len(com)!=0 else print(-1)