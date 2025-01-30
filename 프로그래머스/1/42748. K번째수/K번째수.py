def solution(array, commands):
    b=[]
    for i in commands:
        a=sorted(array[i[0]-1:i[1]])
        b.append(a[i[2]-1])
    return b