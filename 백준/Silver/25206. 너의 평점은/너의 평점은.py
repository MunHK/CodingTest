total=0
grade=0
con={'A+':4.5,'A0':4.0,'B+':3.5,'B0':3.0,'C+':2.5,'C0':2.0,'D+':1.5,'D0':1.0,'F':0}
for _ in range(20):
  n=list(input().split())
  if n[2]=='P':
    continue
  total+=float(n[1])
  grade+=float(n[1])*con[n[2]]
print(grade/total)
  