def solution(s):
    answer = list(map(int,s.split()))
    print(answer)
    return str(min(answer))+" "+str(max(answer))