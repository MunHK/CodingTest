def solution(numbers):
    answer = max(numbers)
    numbers.remove(answer)
    return answer*max(numbers)