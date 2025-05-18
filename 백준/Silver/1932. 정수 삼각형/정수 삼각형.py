import sys
input=sys.stdin.readline
n=int(input())
tri=[]
for _ in range(n):
    tri.append(list(map(int,input().split())))
if n==1:
    print(tri[0][0])
    exit(0)
tri[1][0]+=tri[0][0]
tri[1][1]+=tri[0][0]
for i in range(2,n):
    for j in range(i+1):
        if j==0:
            tri[i][j]+=tri[i-1][j]
        elif j==i:
            tri[i][j]+=tri[i-1][j-1]
        else:
            tri[i][j]+=max(tri[i-1][j-1],tri[i-1][j])
print(max(tri[n-1]))
