def solution(my_string, n):
    answer = ''
    answer=[i*n for i in my_string]
    return ''.join(answer)