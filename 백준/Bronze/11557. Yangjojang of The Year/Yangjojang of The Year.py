def find(n):
  return int(n[1])

t=int(input())

for _ in range(t):
  n=int(input())
  a=[]
  for i in range(n):
    a.append(list(map(str,input().split())))
  a.sort(key=find)
  print(a[-1][0])