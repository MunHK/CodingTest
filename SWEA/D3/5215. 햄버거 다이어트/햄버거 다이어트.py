def btk(start, score, cal):  # [0]=점수 [1]=칼로리
    if cal > l:
        return
    else:
        result.append(score)
    for i in range(start, n):
        btk(i + 1, score + ham[i][0], cal + ham[i][1])

for case in range(1,int(input())+1):
    n,l=map(int,input().split())
    ham=[]
    result=[]
    for _ in range(n):
        a,b=map(int,input().split())
        ham.append([a,b])
    btk(0,0,0)
    print(f'#{case} {max(result)}')