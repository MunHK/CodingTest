n=[]
m=int(input())
for _ in range(m):
    n.append(int(input()))
n.sort()
print("\n".join(map(str,n)))