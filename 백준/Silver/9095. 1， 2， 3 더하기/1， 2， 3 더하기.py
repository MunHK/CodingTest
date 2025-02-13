n=int(input())
num=[]
for _ in range(n):
    num.append(int(input()))
result=[0]*12
result[1]=1
result[2]=2
result[3]=4

for i in range(4,12):
    result[i]=result[i-1]+result[i-2]+result[i-3]

for j in num:
    print(result[j])