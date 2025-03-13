num=[True]*10001
num[1]=False
for i in range(2,int(10000**0.5)+1):
  if num[i]:
    for j in range(i*2,10001,i):
      num[j]=False

m=int(input())
n=int(input())
result=[]
for i in range(m,n+1):
  if num[i]:
    result.append(i)
if len(result)==0:
  print(-1)
else:
  print(f'{sum(result)}\n{result[0]}')