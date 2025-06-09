a=int(input())
b=int(input())
a=a//100*100
for i in range(100):
    num=a+i
    if num%b==0:
        a=num
        break
result=str(a)
print(result[-2::])