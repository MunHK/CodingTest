n=int(input())
word=input()
chk=['y','u','i','o','p','h','j','k','l','b','n','m']
if word[-1] in chk:
    print(0)
else:
    print(1)