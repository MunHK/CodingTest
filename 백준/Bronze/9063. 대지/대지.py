import sys
input=sys.stdin.readline
n=int(input())
max_x,max_y,min_x,min_y=-10001,-10001,10001,10001
result_x,result_y=0,0
if n<2:
  print(0)
else:
  for _ in range(n):
    x,y=map(int,input().split())
    if x>max_x:
      max_x=x
    if x<min_x:
      min_x=x
    if y>max_y:
      max_y=y
    if y<min_y:
      min_y=y
  if min_x<0 and max_x<0:
    result_x=-(min_x-max_x)
  else:
    result_x=max_x-min_x
  if min_y<0 and max_y<0:
    result_y=-(min_y-max_y)
  else:
    result_y=max_y-min_y
  print(result_x*result_y)