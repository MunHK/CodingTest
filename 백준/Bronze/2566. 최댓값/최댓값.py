num=[]
m=-1
a,b=0,0
for _ in range(9):
  num.append(list(map(int,input().split())))

for i in range(9):
  if m<max(num[i]):
    m=max(num[i])
    a=i+1
    b=num[i].index(max(num[i]))+1
print(f'{m}\n{a} {b}')