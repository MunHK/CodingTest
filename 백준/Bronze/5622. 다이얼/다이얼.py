word=input()
di=['','ABC','DFE','GHI','JKL','MNO','PQRS','TUV','WXYZ']
result=0
for i in range(1,9):
  for j in word:
    if j in di[i]:
      result+=i+2
print(result)