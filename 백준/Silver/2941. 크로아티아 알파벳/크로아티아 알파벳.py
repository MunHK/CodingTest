word=input()
result=0
cro=['c=','c-','dz=','d-','lj','nj','s=','z=']
for i in cro:
  result+=word.count(i)
  word=word.replace(i,'0')
word=word.replace('0','')
print(result+len(word))