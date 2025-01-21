def solution(s1, s2):
    answer = 0
    return sum([1 for i in s1 if i in s2])
    