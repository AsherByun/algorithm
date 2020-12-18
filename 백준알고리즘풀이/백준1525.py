from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()
# input 을 저함수로 사용하겠다는 lambda
if __name__ == '__main__':

    def bfs(start):
        q = deque()
        q.append(start)
        dist[start] = 0

        while q:
            now = q.popleft()
            if now == '123456789':
                return dist[now]
            #현재 포지션이 완성포지션이면 그값이 정답
            idx = now.find('9')
            x, y = idx//3, idx%3
            #움직일 9번의 위치를 찾고 맵에 맞춰 x,y를 만듬
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx <3 and 0<= ny < 3:
                    nk = nx*3 + ny
                    ns = list(now)

                    ns[idx], ns[nk] = ns[nk], ns[idx]
                    nd = ''.join(ns)
                    #포지션을 찾은뒤 문자열로 변경
                    #있던포지션이면 다시 사용할 이유없음
                    #없던 포지션이면 현재 포지션에서 +1
                    if not dist.get(nd):
                        dist[nd] = dist[now] +1
                        q.append(nd)

        return -1

    dx = [1,-1,0,0]
    dy = [0,0,1,-1]

    dist = dict()
    start=''

    for _ in range(3):
        s = input()
        s = s.replace(' ','')
        start += s

    start = start.replace('0','9')

    print(bfs(start))

# 문제를 처음에 bfs로 풀면 end point가 없어서 아닐줄 알았다
# 중복된 포지션이 나오면 end point로 생각
# bfs 시 포지션을 하나의 문자열로 사용
# 맵은 x/n y%n으로 사용가능
