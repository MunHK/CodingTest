def solution(n):
    answer = 0
    result=[]
    ori=1
    while n>0:
        answer=n%3
        n//=3
        result.append(answer)
    answer=0
    for i in result[::-1]:
        answer+=i*ori
        ori*=3
    return answer