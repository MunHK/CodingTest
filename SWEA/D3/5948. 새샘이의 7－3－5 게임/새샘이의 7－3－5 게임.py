import itertools
for case in range(1,int(input())+1):
    num=list(map(int,input().split()))
    result=[]
    for i in itertools.combinations(num,3):
        result.append(sum(i))
    result=sorted(list(set(result)),reverse=True)
    print(f'#{case} {result[4]}')