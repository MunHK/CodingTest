result=[0]*10
num=1
for _ in range(3):
    num*=int(input())
for i in range(10):
    result[i]+=str(num).count(str(i))
print(*result,sep='\n')