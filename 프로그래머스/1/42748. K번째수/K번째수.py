def solution(array, commands):
    b=[]
    for i,j,k in commands:
        b.append(sorted(array[i-1:j])[k-1])
    return b