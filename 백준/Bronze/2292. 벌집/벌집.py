n=int(input())
num=1
result=1
while True:
  if n<=num:
    print(result)
    break
  else:
    num+=6*result
    result+=1