def solution(progresses, speeds):
    answer = []
    while len(progresses)!=0:
        print(progresses)
        if progresses[0]<100:
            answer.append(0)
            if (100-progresses[0])%speeds[0]==0:
                num=(100-progresses[0])//speeds[0]
            else:
                num=int((100-progresses[0])//speeds[0])+1

            for j in range(len(progresses)):
                progresses[j]+=speeds[j]*num

        else:
            answer[-1]+=1
            progresses.remove(progresses[0])
            speeds.remove(speeds[0])
    return answer
            