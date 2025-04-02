import itertools
n,k=map(int,input().split())
num=[i for i in range(1,n+1)]
for i in itertools.permutations(num,k):
    for j in range(k):
        print(i[j],end=' ')
    print()
