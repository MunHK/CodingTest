n=[]
for _ in range(3):
  n.append(str(input()))
print(int(n[0])+int(n[2])) if n[1]=="+" else print(int(n[0])*int(n[2]))