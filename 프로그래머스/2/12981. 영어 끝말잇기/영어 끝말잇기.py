def solution(n, words):
    answer = []
    result=[0,0]
    start=words[0][-1]
    answer.append(words[0])
    
    for i in range(1,len(words)):
        if (start!=words[i][0]) or (words[i] in answer):
            result[0]=((i+1)%n if (i+1)%n!=0 else n)
            result[1]=((i+1)//n if (i+1)%n==0 else (i+1)//n+1)#8 
            break
        answer.append(words[i])
        start=words[i][-1]
    return result