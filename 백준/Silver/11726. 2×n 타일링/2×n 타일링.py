import sys
input=sys.stdin.readline
n=int(input())
num=[0]*(n+2)
num[1]=1
num[2]=2
for i in range(3,n+1):
    num[i]=num[i-2]+num[i-1]
print(num[n]%10007)