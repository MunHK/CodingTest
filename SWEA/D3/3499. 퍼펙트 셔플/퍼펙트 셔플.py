for case in range(1,int(input())+1):
    n=int(input())
    card=list(map(str,input().split()))
    result=[]
    if len(card)%2==0:
        for i in range(len(card)//2):
            result.append(card[i])
            result.append(card[len(card)//2+i])
    else:
        for i in range(len(card)//2+1):
            if i==len(card)//2:
                result.append(card[i])
                break
            result.append(card[i])
            result.append(card[len(card)//2+1+i])
    print(f'#{case} ',end='')
    print(*result)