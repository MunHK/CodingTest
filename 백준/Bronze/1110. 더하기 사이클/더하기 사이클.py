n=int(input())
num=n
result=0
while True:
    result+=1
    num=(num//10+num%10)%10 + num%10*10
    if num==n:
        break
print(result)