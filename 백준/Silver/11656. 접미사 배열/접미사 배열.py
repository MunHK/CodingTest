s=input()
word=[]
for i in range(len(s)):
    word.append(s[i::])
print(*sorted(word),sep='\n')