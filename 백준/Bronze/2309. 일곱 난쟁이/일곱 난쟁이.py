height=[]

for i in range(9):
    height.append(int(input()))

for j in range(8):
    num=sum(height)-100-height[j]
    if num in height[j+1:]:
        height.remove(height[j])
        height.remove(num)
        break

for k in sorted(height):
    print(k)