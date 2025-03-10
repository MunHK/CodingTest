w=input().upper()
word=list(set(w))
result=[]
for i in word:
  result.append(w.count(i))
if result.count(max(result))>1:
  print('?')
else:
  print(word[result.index(max(result))])