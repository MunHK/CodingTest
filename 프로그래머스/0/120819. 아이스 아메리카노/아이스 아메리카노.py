def solution(money):
    result=[0,0]
    result[0],result[1]=money//5500,money%5500
    return result