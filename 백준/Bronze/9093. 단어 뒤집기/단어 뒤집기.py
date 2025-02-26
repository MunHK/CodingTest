n=int(input())
result=[]
for i in range(n):
    result=list(map(str,input().split()))
    for i in result:
        print(i[::-1],end=' ')
    print()