n=int(input())
a=2
while(n>1):
  if n%a==0:
    print(a)
    n//=a
    continue
  a+=1