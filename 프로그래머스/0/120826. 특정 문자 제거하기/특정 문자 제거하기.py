def solution(my_string, letter):
    answer = ''
    answer=[i for i in my_string if i not in letter]
    return ''.join(answer)