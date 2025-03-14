import sys
input=sys.stdin.readline
num=[]
for i in range(3):
  num.append(int(input()))
if sum(num)==180:
  if num.count(num[0])==3:
    print('Equilateral')
  elif num.count(num[0])==2 or num.count(num[1])==2:
    print('Isosceles')
  else:
    print('Scalene')
else:
  print('Error')  