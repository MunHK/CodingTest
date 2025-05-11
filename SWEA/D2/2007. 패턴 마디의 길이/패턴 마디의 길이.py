for case in range(1,int(input())+1):
    word=input()
    i=0
    while True:
        i+=1
        if word[:i+1]==word[i+1:(i+1)*2]:
            print(f'#{case} {len(word[:i+1])}')
            break