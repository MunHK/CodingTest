import sys
input=sys.stdin.readline
n=int(input())
line=[]
result=0
for _ in range(n):
    line.append(list(map(int,input().split())))

line.sort()
start,end=line[0][0],line[0][1]
for i in line[1::]:
    if i[0]>end:
        result+=end-start
        start=i[0]
        end=i[1]
    else:
        start=min(start,i[0])
        end=max(end,i[1])
result+=end-start
print(result)