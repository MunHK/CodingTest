num=list(map(int,input().split()))
for x in range(-999,1000):
    for y in range(-999,1000):
        if num[0]*x+num[1]*y==num[2] and num[3]*x+num[4]*y==num[5]:
            print(x,y)
            break