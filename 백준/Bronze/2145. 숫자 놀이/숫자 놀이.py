while True:
    n=input()
    if n=='0':
        break
    num=list(map(int,n))
    while len(num)!=1:
        n=str(sum(num))
        num=list(map(int,n))
    print(n)