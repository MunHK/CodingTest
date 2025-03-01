def solution(sizes):
    a,b=0,0
    for i in sizes:
        if i[1]>i[0]:
            i[0],i[1]=i[1],i[0]
        if i[0]>a:
            a=i[0]
        if i[1]>b:
            b=i[1]
    return a*b