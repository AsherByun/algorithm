from sys import stdin,stdout
from itertools import combinations

if __name__ == '__main__':
    def find(lst,combinations):
        count = 0
        for str_ in lst:
            isPossible = True
            for c in str_:
                if c not in combinations:
                    isPossible = False
                    break
            if isPossible:
                count+=1
        return  count

    n, m = list(map(int, stdin.readline().split()))

    if m < 5 or m == 26:
        print(0)
        exit(0)

    check = set(['a', 'n', 't', 'i', 'c'])
    inChar = set()
    lst = list()
    for _ in range(n):
         inStr = stdin.readline().strip()
         lst.append(inStr[4:len(inStr)-4])
         for c in inStr:
             if c not in inChar and c not in check:
                 inChar.add(c)

    max = 0

    if len(inChar) <= m-5:
        print(len(lst))
        exit(0)

    for combi in combinations(inChar,m-5):
        total = find(lst,list(combi)+list(check))
        if max < total:
            max = total

    print(max)