n=int(input())
for i in range(n):
  a,b=list(map(str,input().split()))
  for j in b:
    print(j*int(a),end="")
  print()