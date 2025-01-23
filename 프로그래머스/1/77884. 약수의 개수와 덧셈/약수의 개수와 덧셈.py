def solution(left, right):
    answer=0
    for i in range(left,right+1):
        cnt=0
        for j in range(1,i+1):
            if(i%j==0):
                cnt+=1
        answer=answer-i if cnt%2 else answer+i
    return answer