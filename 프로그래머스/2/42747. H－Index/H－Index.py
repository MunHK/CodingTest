def solution(citations):
    citations.sort()
    num=len(citations)
    print(citations)
    for i in range(num):
        cnt=0
        for j in citations:
            if j>=num:
                cnt+=1
        if(cnt>=num):
            return num
        num-=1
    return num
            