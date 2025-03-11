n,m= map(int,input().split())
num=[]
mum=[]
for _ in range(n):
  num.append(list(map(int,input().split())))
for _ in range(n):
  mum.append(list(map(int,input().split())))
for i,j in zip(num,mum):
  for x,y in zip(i,j):
    print(x+y,end=' ')
  print()