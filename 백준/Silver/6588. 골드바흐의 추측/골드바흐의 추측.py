import sys
input=sys.stdin.readline
prime=[True]*1000001
prime[0]==False
prime[1]==False
for i in range(2,int(1000001**0.5)+1):
    if prime[i]:
        for j in range(i*2,1000001,i):
            prime[j]=False

while True:
    n=int(input())
    if n==0:
        break
    for l in range(3,n-2,2):
        if prime[l] and prime[n-l]:
            print(f'{n} = {l} + {n-l}')
            break
