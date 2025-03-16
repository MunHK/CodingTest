import sys
input=sys.stdin.readline

num=list(input().strip('\n'))
num.sort(reverse=True)
print(''.join(map(str,num)))