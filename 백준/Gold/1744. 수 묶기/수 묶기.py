n=int(input())
sm=0
mnum=[]
num=[]
result=0
for _ in range(n):
    a=int(input())
    if a>0:
        num.append(a)
    else:
        mnum.append(a)

num.sort(reverse=True)
mnum.sort()
for i in num:
    if sm!=0:
        if i==1:
            result+=i+sm
            sm=0
        else:
            result+=i*sm
            sm=0
    else:
        sm=i
result+=sm
sm=0
for i in mnum:
    if sm!=0:
        result+=i*sm
        sm=0
    else:
        sm=i
result+=sm
print(result)
