import math
def solution(n, m):
    answer = [math.gcd(n,m)]
    for i in range(2,n*m+1):
        if (i%n==0 and i%m==0):
            answer.append(i)
            break
    return answer