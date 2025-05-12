code=['0001101','0011001','0010011','0111101','0100011','0110001','0101111','0111011','0110111','0001011']
for case in range(1,int(input())+1):
    n,m=map(int,input().split())
    result=0
    num=[]
    come=''
    for _ in range(n):
        a=input()
        if '1' in a and not come:
            come=a
    for i in range(m-1,-1,-1):
        if come[i]=='1':
            come=come[i-55:i+1:]
            break
    for i in range(8):
        num.append(code.index(come[i*7:i*7+7:]))
        if i%2==1:
            result+=num[i]
        else:
            result+=num[i]*3
    print('#'+str(case),end=' ')
    print(sum(num)) if result%10==0 else print(0)