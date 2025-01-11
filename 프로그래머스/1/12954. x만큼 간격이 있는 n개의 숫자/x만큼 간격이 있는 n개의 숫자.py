def solution(x, n):
    answer = []
    ans=x
    for i in range(n):
        answer.append(ans)
        ans+=x
    return answer