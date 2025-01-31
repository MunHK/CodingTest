import sys
n=[]
m=int(input())
for _ in range(m):
    n.append(int(sys.stdin.readline()))
n.sort()
print("\n".join(map(str,n)))