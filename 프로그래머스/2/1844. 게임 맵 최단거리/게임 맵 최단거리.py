from collections import deque

def solution(maps):
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    n=len(maps)
    m=len(maps[0])
    def bfs():
        q=deque()
        q.append([0,0])
        visited=False
        while q:
            x,y=q.popleft()
            if x==n-1 and y==m-1:
                visited=True
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]
                if 0<=nx<n and 0<=ny<m and maps[nx][ny]==1:
                    q.append([nx,ny])
                    maps[nx][ny]=maps[x][y]+1
        return visited
    visit=bfs()
    return maps[n-1][m-1] if visit else -1