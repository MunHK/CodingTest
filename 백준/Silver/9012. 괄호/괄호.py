n=int(input())
for _ in range(n):
    ps=input()
    while '()' in ps:
        ps=ps.replace('()','')
    print('YES') if len(ps)==0 else print('NO')