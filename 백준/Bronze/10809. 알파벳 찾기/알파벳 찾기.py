word=input()
rng='abcdefghijklmnopqrstuvwxyz'

for i in rng:
  if i in word:
    print(word.index(i),end=' ')
  else:
    print(-1,end=' ')