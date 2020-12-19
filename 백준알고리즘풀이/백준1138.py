from sys import stdin

def find(lst,check):

    if len(lst) == n:
        print(' '.join(map(str,lst)))
        exit(0)

    for i in range(1,n+1,1):
        if check[i] == True: continue
        upper = 0
        for j in lst:
            if j > i : upper+=1

        if order[i] == upper:
            check[i]=True
            lst.append(i)
            find(lst,check)
            lst.remove(i)
            check[i]=False

if __name__ == '__main__':

    n = int(input())

    nums = [i for i in range(n)]
    order = [int(i) for i in stdin.readline().split()]
    order.insert(0,0)
    check = [False for _ in range(10)]

    for i in range(1,n+1,1):
        if order[i] == 0:
            lst = [i]
            check[i] = True
            find(lst,check)
            check[i] = False

