while True:
  n=int(input())
  num=[1]
  if n==-1:
    break
  for i in range(2,int(n**0.5)+1):
    if n%i==0:
      num.append(i)
      num.append(n//i)
  if sum(num)==n:
    print(f'{n} = ',end='')
    for j in sorted(num)[:-1:]:
      print(j,end=' + ')
    print(sorted(num)[-1])
  else:
    print(f'{n} is NOT perfect.')