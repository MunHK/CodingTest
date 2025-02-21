def solution(cacheSize, cities):
    result=[]
    time=0
    if cacheSize==0:
        return len(cities)*5
    else:
        for i in cities:
            i=i.lower()
            if i not in result:
                if len(result)<cacheSize:
                    result.append(i)
                    time+=5
                elif len(result)==cacheSize:
                    result.remove(result[0])
                    result.append(i)
                    time+=5
            elif i in result:
                result.remove(i)
                result.append(i)
                time+=1
    return time