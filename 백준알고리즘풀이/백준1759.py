from itertools import combinations
from sys import stdin, stdout

if __name__ == '__main__':
    l,c = list(map(int,stdin.readline().split()))
    dict_ = list(stdin.readline().split())
    dict_ = sorted(dict_)

    combi = list(combinations(dict_,l))

    vowel = ('a','e','i','o','u')

    for lst in combi:
        count = 0

        for c in lst:
            if c in vowel:
                count += 1

        constant = l - count

        if constant >= 2 and count >= 1:
            print(''.join(lst))