import itertools
import math
n=int(input())
for _ in range(n):
    num=list(map(int,input().split()))
    result=0
    for i in itertools.combinations(num[1:],2):
        a,b=i[0],i[1]
        result+=math.gcd(a,b)
    print(result)