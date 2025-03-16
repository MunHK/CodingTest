n=int(input())
result=[2000]*8001

for rd in range(1001):
    for th in range(1001):
        result[rd*3+th*5]=min(result[rd*3+th*5],rd+th)
print(result[n] if result[n]!=2000 else -1)