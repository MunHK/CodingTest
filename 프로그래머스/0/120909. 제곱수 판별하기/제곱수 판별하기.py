def solution(n):
    answer=[]
    for i in range(1,n):
        if n%i==0:
            answer.append(i)
    for i in answer:
        if (i*i)==n:
            return 1
    return 2