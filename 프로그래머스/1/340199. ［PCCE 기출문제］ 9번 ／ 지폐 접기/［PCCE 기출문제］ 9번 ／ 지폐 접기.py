def solution(wallet, bill):
    answer=0
    while True:
        if bill[0]<bill[1]:
            bill[0],bill[1]=bill[1],bill[0]
        if wallet[0]<wallet[1]:
            wallet[0],wallet[1]=wallet[1],wallet[0]
        if bill[1]<=wallet[1] and bill[0]<=wallet[0]:
            break
        else:
            bill[0]//=2
            answer+=1
    return answer