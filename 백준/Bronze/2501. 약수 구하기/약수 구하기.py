n,k=map(int,input().split())
num=[]
for i in range(1,n+1):
  if n%i==0:
    num.append(i)
try:
  print(num[k-1])
except:
  print(0)