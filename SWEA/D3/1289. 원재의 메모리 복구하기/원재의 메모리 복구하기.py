for case in range(1,int(input())+1):
    n=input()
    fix=n[0]
    result=0 if n[0]=='0' else 1

    for i in n[1::]:
        if i!=fix:
            result+=1
            fix=i
    print(f'#{case} {result}')
    
