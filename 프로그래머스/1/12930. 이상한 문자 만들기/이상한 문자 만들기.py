def solution(s):
    answer = s.split(" ")
    ans=[]
    for i in answer:
        a=''
        for j in range(len(i)):
            if j%2==0:
                a+=i[j].upper()
            else:
                a+=i[j].lower()
        ans.append(a)
    return ' '.join(ans)