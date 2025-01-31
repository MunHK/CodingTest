n=[]
for i in range(5):
  n.append(int(input()))
  if(n[i]<40):
    n[i]=40
print(sum(n)//5)
  