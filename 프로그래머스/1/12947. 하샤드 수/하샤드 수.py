def solution(x):
    answer = 0
    a=x
    while(x>0):
        answer+=x%10
        x//=10
    if a%answer==0:
        return True
    else:
        return False