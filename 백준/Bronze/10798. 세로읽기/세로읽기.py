word=[]
m=0
for _ in range(5):
  a=input()
  word.append(a)
  if m<len(a):
    m=len(a)
for i in range(m):#6
  for j in range(5):
    try:
      print(word[j][i],end='')
    except:
      pass