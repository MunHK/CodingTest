for case in range(1,int(input())+1):
    word=input()
    q=[]
    result=0
    for i in word:
        if i in ['(','{']:
            q.append(i)
        elif i in [')','}']:
            if not q:
                break
            a=q.pop()
            if i==')':
                if a!='(':
                    break
            elif i=='}':
                if a!='{':
                    break
    else:
        if not q:
            result=1
    print(f'#{case} {result}')
