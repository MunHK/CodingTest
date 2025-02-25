import itertools
def solution(nums):
    answer = 0
    result=[True]*3000
    for i in range(2,3000**2):
        for j in range(i*2,3000,i):
            result[j]=False
    for i in itertools.combinations(nums,3):
        if result[sum(i)]:
            answer+=1
    return answer