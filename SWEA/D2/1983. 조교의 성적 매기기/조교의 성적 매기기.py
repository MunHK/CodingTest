t=int(input())
for case in range(1,t+1):
    n,k=map(int,input().split())
    score=[]
    grade={1:'A+',2:'A0',3:'A-',4:'B+',5:'B0',6:'B-',7:'C+',8:'C0',9:'C-',10:'D0'}
    for i in range(1,n+1):
        a,b,c=map(int,input().split())
        score.append([i,(a*35+b*45+c*20)/100])
    score.sort(reverse=True,key=lambda x:x[1])

    for i in range(n):
        if score[i][0]==k:
            print(f'#{case} {grade.get((i+n//10)*10//n)}')