st=''
for i in range(46):
    st+=(str(i)+' ')*i
num=list(map(int,st.split()))
a,b=map(int,input().split())
print(sum(num[a-1:b]))
