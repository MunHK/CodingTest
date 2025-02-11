def solution(answers):
    st = [1,2,3,4,5]*2000
    nd = [2,1,2,3,2,4,2,5]*1250
    rd = [3,3,1,1,2,2,4,4,5,5]*1000
    result=[0,0,0]
    answer=[]
    for i in range(len(answers)):
        if answers[i]==st[i]:
            result[0]+=1
        if answers[i]==nd[i]:
            result[1]+=1
        if answers[i]==rd[i]:
            result[2]+=1
    
    if result.count(max(result))!=1:
        for i in range(3):
            if result[i]==max(result):
                answer.append(i+1)
        answer.sort()
        return answer
    else:
         return [result.index(max(result))+1]       
        
        