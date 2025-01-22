def solution(s):
    answer = s.split()
    result=[]
    for i in answer:
        result.append(int(i))
    result.sort()
    return f"{result[0]} {result[-1]}"