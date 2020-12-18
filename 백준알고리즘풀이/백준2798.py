from itertools import combinations
from sys import stdin, stdout

if __name__ == '__main__':
    n, m = map(int,stdin.readline().split())

    values = list(map(int, stdin.readline().split()))

    combi = list(combinations(values,3))

    min = 999999999999
    res = 0
    for lst in combi:
        sum_ = sum(lst)
        if abs(sum_-m) < min and sum_ <= m:
            min=abs(sum_-m)
            res = sum_

    stdout.write(str(res))
    stdout.close()