n=int(input())
num=1
result=0
while num!=n:
    lnum=list(map(int,str(num)))
    if n == num+sum(lnum):
        result=num
        break
    num+=1
print(result)