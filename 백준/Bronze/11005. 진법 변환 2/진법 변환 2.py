n,b=map(int,input().split())
result=''
ch=['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K',
    'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
while n>=b:
  result=ch[n%b]+result
  n//=b
result=ch[n%b]+result
print(result)