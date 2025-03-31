import sys
input=sys.stdin.readline
n=int(input())
num=[0]*1001
num[1]=1
num[2]=3
num[3]=5
for i in range(4,n+1):
    num[i]=num[i-2]*2+num[i-1]
print(num[n]%10007)