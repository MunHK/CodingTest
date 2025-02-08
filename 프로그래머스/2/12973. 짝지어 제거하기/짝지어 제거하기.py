def solution(s):
    answer=[]
    for i in s:
        if len(answer)!=0 and answer[-1]==i:
            answer.pop()
        else:   
            answer.append(i)
    return 1 if not answer else 0