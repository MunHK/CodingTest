n=int(input())
a=len(str(n))
n*=a
while a>1:
    a-=1
    n-=int('9'*a)
print(n)