def solution(n):
    num=[0]*100001
    num[0]=0
    num[1]=1
    for i in range(2,n+1):
        num[i]=num[i-2]+num[i-1]
    return num[n]%1234567