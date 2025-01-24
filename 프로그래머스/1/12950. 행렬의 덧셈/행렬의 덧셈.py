def solution(arr1, arr2):
    answer1=[]
    for a,b in zip(arr1,arr2): 
        answer=[]
        for i,j in zip(a,b):
            answer.append(i+j)
        answer1.append(answer)
    return answer1