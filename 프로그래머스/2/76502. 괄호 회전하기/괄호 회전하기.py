def solution(s):
    answer = 0
    a=['(','{','[']
    for _ in range(len(s)-1):
        ans=[]
        for i in s:
            if i in ['(','{','[']:
                ans.append(i)
            else:
                if len(ans)==0:
                    ans.append(i)
                    break
                else:
                    if ans[-1]=='(' and i==')':
                        ans.pop()
                    elif ans[-1]=='{' and i=='}':
                        ans.pop()
                    elif ans[-1]=='[' and i==']':
                        ans.pop()
        if len(ans)==0:
            answer+=1
        s=s[1:]+s[0]
    return answer