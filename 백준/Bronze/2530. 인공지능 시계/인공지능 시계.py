h,m,s=map(int,input().split())
n=int(input())
s+=n
m=m+s//60
h=h+m//60
print(h%24,m%60,s%60)