for case in range(1,int(input())+1):
    word=input()
    result=0
    l=len(word)
    if l%2==1:
        if word[:l//2]==word[-1:l//2:-1]:
            result+=1
    else:
        if word[:l//2]==word[-1:l//2-1:-1]:
            result+=1
    print(f'#{case} {result}')