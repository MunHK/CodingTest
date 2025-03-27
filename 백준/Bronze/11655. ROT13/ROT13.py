word=input()
for i in word:
    num=0
    if 'A'<=i<='Z' or 'a'<=i<='z':
        if 'A'<=i<='Z' and ord(i)+13>90:
            num=(ord(i)+13)%90+64
        elif 'a'<=i<='z' and ord(i)+13>122:
            num=(ord(i)+13)%122+96
        else:
            num=ord(i)+13
        print(chr(num),end='')
    else:
        print(i,end='')