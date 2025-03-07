import sys
input=sys.stdin.readline

h,m=map(int,input().split())
if m<45:
    if h==0:
        h=24
    h-=1
    m+=60-45
else:
    m-=45  
print(h,m)