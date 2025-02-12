import itertools

height=[]

for i in range(9):
    height.append(int(input()))

for i in itertools.combinations(height,7):
    if sum(i)==100:
        for j in sorted(i):
            print(j)
        break