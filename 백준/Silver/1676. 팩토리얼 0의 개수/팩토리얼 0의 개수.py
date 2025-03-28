n=int(input())
result=1
for i in range(2,n+1):
    result*=i
chre=str(result)
result=0
for i in range(1,len(chre)+1):
    if chre[-i]=='0':
        result+=1
    else:
        break
print(result)