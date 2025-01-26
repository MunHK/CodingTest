def solution(t, p):
    answer,answer1 = [],[]
    
    for i in range(len(t)-len(p)+1):
        ans=''
        for j in range(len(p)):
            ans+=t[i+j]
        answer.append(int(ans))
        
    for i in answer:
        if i<=int(p): answer1.append(i)
        
    return len(answer1)