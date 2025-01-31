while 1:
  a=[]
  b=0
  n=int(input())
  
  if n==-1: break
    
  for i in range(1,n//2+1):
    if n%i==0:
      a.append(i)
      b+=i
      
  if n!=b:
    print(f"{n} is NOT perfect.")
  else:
    print(f"{n} = "+" + ".join(map(str,a)))