def solution(numbers):
    result=[]
    numbers.sort()
    for i in range(len(numbers)):
        for j in range(i+1,len(numbers)):
            result.append(numbers[i]+numbers[j])
    return sorted(list(set(result)))