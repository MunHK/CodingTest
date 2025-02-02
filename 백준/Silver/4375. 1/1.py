import sys

for line in sys.stdin:
    n = int(line.strip())
    a = '1'
    
    while int(a) % n != 0:
        a += '1'
    
    print(len(a))
