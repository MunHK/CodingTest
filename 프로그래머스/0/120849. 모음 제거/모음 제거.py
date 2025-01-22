def solution(my_string):
    answer = ''
    answer=[i for i in my_string if i not in {'a','e','i','o','u'}]
    return ''.join(answer)