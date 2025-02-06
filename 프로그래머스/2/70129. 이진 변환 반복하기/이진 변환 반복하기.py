def solution(s):
    result=[0,0]
    answer=''
    while(s!='1'):
        result[0]+=1
        result[1]+=s.count("0")
        answer=s.replace("0","")
        s=str(bin(len(answer)))[2::]
    return result