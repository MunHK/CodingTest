n=int(input())
num=list(map(int,input().split()))
snum=sorted(set(num))
dic={}
for i in range(len(snum)):
    dic[snum[i]]=i

for j in num:
    print(dic[j],end=' ')

