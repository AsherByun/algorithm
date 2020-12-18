from itertools import permutations
from sys import stdin, stdout

if __name__ == '__main__':

    n = int(stdin.readline())

    lst = list(map(int, stdin.readline().split()))
    max = 0
    for lll in permutations(lst):
        total=0
        for i in range(len(lll)-1):
            total += abs(lll[i] - lll[i+1])

        if total > max:
            max = total

    print(max)