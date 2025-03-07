import sys
input=sys.stdin.readline

n=int(input())

if n>=90:
    print('A')
elif 80<=n<=89:
    print('B')
elif 70<=n<=79:
    print('C')
elif 60<=n<=69:
    print('D')
else:
    print('F')