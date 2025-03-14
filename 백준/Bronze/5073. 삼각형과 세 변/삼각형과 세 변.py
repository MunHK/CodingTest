import sys
input=sys.stdin.readline
while True:
  num=list(map(int,input().split()))
  if num.count(0)==3:
    break
  num.sort()
  if (num[1]+num[0]-num[2])<=0:
    print('Invalid')
  else:
    if num.count(num[0])==3:
      print('Equilateral')
    elif num.count(num[0])==2 or num.count(num[1])==2:
      print('Isosceles')
    else:
      print('Scalene')