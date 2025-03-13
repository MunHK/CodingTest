num=[True]*1001
num[1]=False
for i in range(2,int(1000**0.5)+1):
  if num[i]:
    for j in range(i*2,1001,i):
      num[j]=False

input()
result=list(map(int,input().split()))

print(sum([1 for i in result if num[i]]))