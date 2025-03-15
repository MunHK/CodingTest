import itertools

n,m=map(int,input().split())
num=list(map(int,input().split()))
result=0

for i in itertools.combinations(num,3):
    if sum(i)>result and sum(i)<=m:
        result=sum(i)
print(result)