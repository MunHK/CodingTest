sr=[[0]*100 for _ in range(100)]
n=int(input())
result=0
for _ in range(n):
  a,b=map(int,input().split())
  for i in range(a,a+10):
    for j in range(b,b+10):
      sr[i][j]=1

for k in range(100):
  result+=sr[k].count(1)
print(result)