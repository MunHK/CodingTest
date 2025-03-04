def solution(n, arr1, arr2):
    answer = []
    for i,j in zip(arr1,arr2):
        result=bin(i|j)[2:].zfill(n)
        result=result.replace('1','#')
        result=result.replace('0',' ')
        answer.append(result)
    return answer