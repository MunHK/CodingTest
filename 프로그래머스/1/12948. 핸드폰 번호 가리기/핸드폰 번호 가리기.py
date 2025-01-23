def solution(phone_number):
    answer = list(map(str,phone_number))
    for i in range(len(answer)-4):
        answer[i]='*'
    return ''.join(answer)