import sys
input=sys.stdin.readline
word=input().strip()
n=int(input())
lc=list(word)
rc=[]
for _ in range(n):
    co=list(map(str,input().split()))
    if co[0]=='L' and lc:
        rc.append(lc.pop())
    elif co[0]=='D' and rc:
        lc.append(rc.pop())
    elif co[0]=='B' and lc:
        lc.pop()
    elif co[0]=='P':
        lc.append(co[1])
lc+=rc[::-1]
print(*lc,sep='')