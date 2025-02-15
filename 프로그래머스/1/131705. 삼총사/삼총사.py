import itertools
def solution(number):
    result=0
    answer=itertools.combinations(number,3)
    for i in answer:
        if sum(i)==0:
            result+=1
    return result