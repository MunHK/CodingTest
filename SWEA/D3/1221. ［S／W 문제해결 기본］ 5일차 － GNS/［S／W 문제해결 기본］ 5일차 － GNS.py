word=["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
for case in range(1,int(input())+1):
    input()
    cnt=[0]*10
    com=list(map(str,input().split()))
    for i in range(10):
        cnt[i]=com.count(word[i])
    print('#'+str(case))
    for i in range(10):
        print((word[i]+' ')*cnt[i],end='')