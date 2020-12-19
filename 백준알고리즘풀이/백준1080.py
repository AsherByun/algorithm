from sys import stdin

def flip(x,y,A):
    for i in range(x,x+3,1):
        for j in range(y,y+3,1):
            if A[i][j] == 0: A[i][j] = 1
            else: A[i][j] = 0

if __name__ == '__main__':
    n, m = list(map(int,stdin.readline().split()))

    A = []
    B = []

    for i in range(n):
        A.append(list(map(int,input())))

    for i in range(n):
        B.append(list(map(int,input())))


    cnt = 0

    for i in range(n-2):
        for j in range(m-2):
            if A[i][j] != B[i][j]:
                flip(i,j,A)
                cnt+=1

    can = True
    for i in range(n):
        for j in range(m):
            if A[i][j] != B[i][j]:
                can=False
                break

    if can:
        print(cnt)
    else:
        print('-1')

# 처음에는 bfs를 사용해서 모든 경우의수 맨위왼쪽부터 모든 경우마다 다도는 경우를 생각함
# 그중에 겹치는게 없을때만 큐에 넣고 사용할 생각이였음
# 생각해보니까 1,0 다를경우엔 무조건 바꿔야함
# 지나간 순서는 다시 바뀌지 않기때문에 다를때 바꿈 -> 훨씬 간단해짐