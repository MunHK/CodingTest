ch=[0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']

a,b=map(int,input().split())
m=int(input())
num=list(map(int,input().split()))
chnum=''

for i in range(len(num)):
    chnum+=str(ch[num[i]])
result=int(chnum,a)
pnt=[]
while result!=0:
    pnt.append(result%b)
    result//=b
print(*pnt[::-1])