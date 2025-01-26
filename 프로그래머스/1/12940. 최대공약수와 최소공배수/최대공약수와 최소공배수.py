def solution(n, m):
    a,b=max(n,m),min(n,m)
    while b>0:
        a,b=b,a%b
    return [a,n*m//a]
    