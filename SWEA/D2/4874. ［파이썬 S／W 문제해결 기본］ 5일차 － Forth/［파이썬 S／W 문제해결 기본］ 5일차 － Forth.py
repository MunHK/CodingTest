for case in range(1,int(input())+1):
    word=list(map(str,input().split()))
    word=word[:-1:]
    q=[]
    print('#'+str(case),end=' ')
    for i in range(len(word)):
        if word[i] in ['-','+','*','/']:
            if len(q)<2:
                q=[]
                break
            a = q.pop()
            b = q.pop()
            if word[i]=='-':
                q.append(b-a)
            if word[i]=='+':
                q.append(a+b)
            if word[i]=='*':
                q.append(a*b)
            if word[i]=='/':
                q.append(b//a)
            if word[i]=='%':
                q.append(b%a)
        else:
            q.append(int(word[i]))
    if len(q)==1 and len(word)!=1:
        print(q[0])
    else:
        print('error')