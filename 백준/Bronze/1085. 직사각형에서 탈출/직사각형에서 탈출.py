x,y,w,h=map(int,input().split())
result=[x,y]
result.append(w-x)
result.append(h-y)
print(min(result))