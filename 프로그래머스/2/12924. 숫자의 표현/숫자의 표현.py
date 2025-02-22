def solution(n):
    result=0
    for i in range(1,n+1):
        num,j=0,i
        while num<=n:
            num+=j
            j+=1
            if num==n:
                result+=1
                break
    return result
                