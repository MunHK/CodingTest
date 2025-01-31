n=int(input())
a=[]
for i in range(n):
  a.append(list(map(str,input().split())))
for j in a:
  num=float(j[0])
  
  for k in range(1,len(j)):
    if j[k]=="@":
      num*=3
    elif j[k]=="%":
      num+=5
    else: 
      num-=7
  print(f"{num:.2f}")