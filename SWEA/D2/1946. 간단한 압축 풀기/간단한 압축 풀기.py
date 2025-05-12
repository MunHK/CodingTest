for case in range(1,int(input())+1):
    n=int(input())
    word=''
    for _ in range(n):
        a,b=map(str,input().split())
        word+=a*int(b)
    print('#'+str(case))
    for i in range(len(word)//10+1):
        print(word[i*10:i*10+10:])