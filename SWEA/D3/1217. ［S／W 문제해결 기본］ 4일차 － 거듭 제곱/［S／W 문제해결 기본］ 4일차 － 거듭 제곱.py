def p(a,b):
    if b==1:
        return a
    return a*p(a,b-1)

for case in range(1,11):
    input()
    x,y=map(int,input().split())
    result=p(x,y)
    print(f'#{case} {result}')