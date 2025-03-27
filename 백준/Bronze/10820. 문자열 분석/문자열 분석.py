import sys
input=sys.stdin.readline

while True:
    result=[0,0,0,0]
    word=input()
    if not word[:-1]:
        break
    for i in word[:-1]:
        if i.islower():
            result[0]+=1
        elif i.isupper():
            result[1]+=1
        elif i==' ':
            result[3]+=1
        else:
            result[2]+=1
    print(*result,sep=' ')
