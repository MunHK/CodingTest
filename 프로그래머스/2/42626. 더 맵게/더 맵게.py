import heapq

def solution(scoville, K):
    result=0
    heapq.heapify(scoville)
    while scoville[0]<K:
        if len(scoville)<=1:
            return -1
        else:
            a=heapq.heappop(scoville)
            b=heapq.heappop(scoville)
            heapq.heappush(scoville,a+b*2)
            result+=1
    return result