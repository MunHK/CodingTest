def solution(price, money, count):
    result=0
    for i in range(1,count+1):
        result+=i*price
    return result-money if money<result else 0
