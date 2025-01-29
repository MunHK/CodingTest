def solution(s):
    answer = list(map(str,s))
    ans=[]
    if(answer.count("(")!=answer.count(")")):
        return False
    
    for i in answer:
        if i=='(':
            ans.append(i)
            continue
            
        else:
            if (ans==[]):
                return False
            
            a=ans.pop()
            
            if (a!='('):
                return False
            
    return True