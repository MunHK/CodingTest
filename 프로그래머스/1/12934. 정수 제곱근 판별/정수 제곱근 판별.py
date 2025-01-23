def solution(n):
    print(int((n**0.5)**2))
    return (n**0.5+1)**2 if int(n**0.5)**2==n else -1