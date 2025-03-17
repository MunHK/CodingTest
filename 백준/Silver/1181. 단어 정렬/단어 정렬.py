n=int(input())
word=[[] for _ in range(51)]
for _ in range(n):
    w=input()
    l=len(w)
    word[l].append(w)
for i in range(1,51):
    if len(word[i])>0:
        for j in sorted(set(word[i])):
            print(j)
